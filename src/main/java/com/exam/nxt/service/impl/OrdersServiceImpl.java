package com.exam.nxt.service.impl;

import com.exam.nxt.common.GenerateId;
import com.exam.nxt.dto.BuyDTO;
import com.exam.nxt.dto.OrderDTO;
import com.exam.nxt.dto.OrderItemDTO;
import com.exam.nxt.dto.ShoppingDTO;
import com.exam.nxt.entity.Orderitem;
import com.exam.nxt.entity.Orders;
import com.exam.nxt.entity.Shopping;
import com.exam.nxt.mapper.OrdersMapper;
import com.exam.nxt.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Resource
    ShoppingServiceImpl shoppingService;
    @Resource
    OrderitemServiceImpl orderitemService;

    //为用户添加未付款的订单
    @CachePut
    @Transactional
    public Orders add(HttpServletRequest request, BuyDTO buyDTO) {
        String ordersId = GenerateId.getOrdersId();
        String uid = NXTUtils.getuid(request);
        OrderDTO orderDTO = buyDTO.getOrderDTO();
        List<OrderItemDTO> itemDTOS = buyDTO.getItemDTOS();
        ShoppingDTO shoppingDTO = buyDTO.getShoppingDTO();
        //创建收货地址
        Shopping shopping = new Shopping();
        BeanUtils.copyProperties(shoppingDTO, shopping);
        shopping.setShoppingid(GenerateId.getShoppingId())
                .setUserid(uid)
                .setOrderid(ordersId)
                .setCreatetime(LocalDateTime.now())
                .setUpdatetime(LocalDateTime.now());
        //创建未付款的订单
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDTO, orders);
        orders.setOrderid(ordersId)
                .setUserid(uid)
                .setShoppingid(shopping.getShoppingid())
                .setPaymenttype(1)
                .setStatus(10)
                .setCreatetime(LocalDateTime.now())
                .setUpdatetime(LocalDateTime.now())
                .setClosetime(LocalDateTime.now().plusHours(24L));
        this.save(orders);
        shoppingService.save(shopping);
        List<Orderitem> orderitems = new ArrayList<>();
        for (OrderItemDTO o : itemDTOS) {
            Orderitem orderitem = new Orderitem();
            BeanUtils.copyProperties(o, orderitem);
            orderitem.setId(GenerateId.getOItemId())
                    .setOrderid(ordersId)
                    .setUserid(uid)
                    .setCreatetime(LocalDateTime.now())
                    .setUpdatetime(LocalDateTime.now());
            orderitems.add(orderitem);
        }
        orderitemService.saveBatch(orderitems);
        return orders;
    }

    private void pay() {
    }
}
