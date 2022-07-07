package com.exam.nxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.AddressDTO;
import com.exam.nxt.entity.Address;
import com.exam.nxt.service.impl.AddressServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
 * @since 2022-07-03
 */
@Api(tags = "个人地址接口")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressServiceImpl service;

    @ApiOperation("查询用户地址")
    @GetMapping("/user")
    @Cacheable
    public Result userAddress(HttpServletRequest request) {
        String uid = NXTUtils.getuid(request);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("userid", uid);
        return Result.success(service.list(wrapper));
    }

    @ApiOperation("添加用户地址")
    @PostMapping("/user")
    @CachePut
    public Result add(HttpServletRequest request, @RequestBody AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        address.setAddressId(GenerateId.addressId())
                .setUserid(NXTUtils.getuid(request))
                .setCreatetime(LocalDateTime.now())
                .setUpdatetime(LocalDateTime.now());
        return Result.success();
    }

    @ApiOperation("通过id删除用户地址")
    @DeleteMapping("/user/{addressId}")
    @CacheEvict
    public Result del(@PathVariable String addressId) {
        return Result.success(service.removeById(addressId));
    }

}
