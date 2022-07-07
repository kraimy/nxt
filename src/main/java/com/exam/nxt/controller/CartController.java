package com.exam.nxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.entity.Cart;
import com.exam.nxt.service.impl.CartServiceImpl;
import com.exam.nxt.utils.JWTUtils;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Api(tags = "购物车接口")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    CartServiceImpl service;

    @ApiOperation("查询用户购物车所有商品")
    @GetMapping("/allPro")
    public Result allPro(HttpServletRequest request) {
        return Result.success(service.allPro(request));
    }

    @ApiOperation("加入购物车")
    @PostMapping("/{proId}/{quantity}")
    @CachePut
    public Result add(HttpServletRequest request,
                      @Parameter(description = "商品编号") @PathVariable String proId,
                      @Parameter(description = "数量") @PathVariable int quantity) {
        Cart cart = new Cart(GenerateId.getCartId(),
                NXTUtils.getuid(request),
                proId,
                quantity,
                0,
                LocalDateTime.now(),
                LocalDateTime.now());
        service.saveOrUpdate(cart);
        return Result.success();
    }

    @ApiOperation("删除已选择的商品")
    @DeleteMapping
    @CacheEvict
    public Result del(HttpServletRequest request) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        wrapper.eq("userid", NXTUtils.getuid(request))
                .eq("checked", 1);
        service.remove(wrapper);
        return Result.success();
    }

    @ApiOperation("选择单个商品")
    @PostMapping("/choose/{carId}")
    @CachePut
    public Result choose(@PathVariable String carId) {
        Cart cart = service.getById(carId);
        cart.setChecked(1);
        service.saveOrUpdate(cart);
        return Result.success();
    }

    @ApiOperation("单个商品取消选择")
    @PostMapping("/unselect/{carId}")
    @CachePut
    public Result unselect(@PathVariable String carId) {
        Cart cart = service.getById(carId);
        cart.setChecked(0);
        service.saveOrUpdate(cart);
        return Result.success();
    }
}
