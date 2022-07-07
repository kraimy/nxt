package com.exam.nxt.controller;


import com.exam.nxt.common.Result;
import com.exam.nxt.dto.BuyDTO;
import com.exam.nxt.service.impl.OrdersServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    OrdersServiceImpl service;
    @ApiOperation("提交购物信息,生成未支付的订单,返回订单id,建议调用者保存订单id,用以调用支付接口")
    @PostMapping()
    public Result add(HttpServletRequest request,@RequestBody BuyDTO buyDTO){
        return Result.success(service.add(request,buyDTO).getOrderid());
    }

}
