package com.exam.nxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.nxt.common.Constants;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.WeChatModel;
import com.exam.nxt.entity.User;
import com.exam.nxt.service.impl.UserServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServiceImpl service;

    @ApiOperation("分页")
    @GetMapping("/page/{current}/{size}")
    @Cacheable
    public Result page(@PathVariable int current, @PathVariable int size) {
        Page<User> page = new Page<>(current, size);
        page = service.page(page);
        return Result.success(page);
    }
    @ApiOperation("通过id查询用户")
    @GetMapping("/{id}")
    @Cacheable
    public Result findById(@PathVariable String id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userid", id);
        User one = service.getOne(wrapper);
        return Result.success(one);
    }

    @ApiOperation("通过id删除用户")
    @DeleteMapping("/{id}")
    @CacheEvict
    public Result removeById(HttpServletRequest request, @PathVariable String id) {
        int role = NXTUtils.getRole(service, NXTUtils.getuid(request));
        if (role == 0) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("userid", id);
            return Result.success(service.remove(wrapper));
        }else return Result.error(Constants.CODE_401,"权限不足");

    }

    @ApiOperation("一键登录或注册普通用户")
    @PostMapping("/login")
    public Result Login(@RequestBody @Validated WeChatModel weChatModel) {
        return service.loginOrRegister(weChatModel);
    }
}
