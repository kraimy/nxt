package com.exam.nxt.controller;


import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.PayinfoDTO;
import com.exam.nxt.entity.Payinfo;
import com.exam.nxt.service.impl.PayinfoServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CachePut;
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
@Api(tags = "支付接口")
@RestController
@RequestMapping("/payinfo")
public class PayinfoController {
    @Resource
    PayinfoServiceImpl service;

    @ApiOperation("支付")
    @PostMapping("/{orderId}")
    @CachePut
    public Result pay(HttpServletRequest request, @PathVariable String orderId, @RequestBody PayinfoDTO payinfoDTO) {
        Boolean pay = service.pay(request, orderId, payinfoDTO);
        if (pay) return Result.success();
        else return Result.error("500", "订单数据错误");
    }
}
