package com.exam.nxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.common.Result;
import com.exam.nxt.entity.Category;
import com.exam.nxt.service.ICategoryService;
import com.exam.nxt.service.impl.CategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Api(tags = "商品分类接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    CategoryServiceImpl service;
    @ApiOperation("查询所有分类")
    @GetMapping
    @Cacheable
    public Result all() {
        return Result.success(service.list());
    }
    @ApiOperation("通过分类id查询商品")
    @GetMapping("/cateId/{cateId}")
    @Cacheable
    public Result productByCateId(@Parameter(description = "分类id") @PathVariable String cateId) {
        return Result.success(service.productByCateId(cateId));
    }

}
