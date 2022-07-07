package com.exam.nxt.service.impl;

import com.exam.nxt.common.GenerateId;
import com.exam.nxt.dto.PayinfoDTO;
import com.exam.nxt.entity.Orders;
import com.exam.nxt.entity.Payinfo;
import com.exam.nxt.mapper.PayinfoMapper;
import com.exam.nxt.service.IPayinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Service
public class PayinfoServiceImpl extends ServiceImpl<PayinfoMapper, Payinfo> implements IPayinfoService {
    @Resource
    OrdersServiceImpl ordersService;

    public Boolean pay(HttpServletRequest request, String orderId, PayinfoDTO payinfoDTO) {
        Payinfo payinfo = new Payinfo();
        BeanUtils.copyProperties(payinfoDTO, payinfo);
        payinfo.setPayid(GenerateId.payId())
                .setOrderid(orderId)
                .setUserid(NXTUtils.getuid(request))
                .setCreatetime(LocalDateTime.now())
                .setUpdatetime(LocalDateTime.now());
        boolean save = this.save(payinfo);
        if (save){
            Orders orders = ordersService.getById(orderId);
            orders.setStatus(20);
            return true;
        }else return false;
    }
}
