package com.exam.nxt.controller;


import com.exam.nxt.service.impl.OrderitemServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Api(tags = "订单详情接口")
@RestController
@RequestMapping("/orderitem")
public class OrderitemController {
    @Resource
    OrderitemServiceImpl service;

}
