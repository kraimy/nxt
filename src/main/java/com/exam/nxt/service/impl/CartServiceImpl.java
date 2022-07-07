package com.exam.nxt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.entity.Cart;
import com.exam.nxt.entity.Product;
import com.exam.nxt.mapper.CartMapper;
import com.exam.nxt.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
    @Resource
    ProductServiceImpl productService;

    @Cacheable
    public List<Product> allPro(HttpServletRequest request) {
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("userid", NXTUtils.getuid(request));
        List<Cart> carts = this.list(cartQueryWrapper);
        List<String> idList = new ArrayList<>();
        carts.forEach(cart -> idList.add(cart.getProid()));
        return productService.listByIds(idList);

    }
}
