package com.exam.nxt.controller;

import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.entity.Collection;
import com.exam.nxt.entity.Product;
import com.exam.nxt.service.impl.CollectionServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-07-04
 */
@Api(tags = "收藏接口")
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    CollectionServiceImpl service;

    @ApiOperation("收藏")
    @PostMapping("/{proId}")
    @CachePut
    public Result add(HttpServletRequest request, @PathVariable String proId) {
        service.save(new Collection(GenerateId.collectionId(), NXTUtils.getuid(request), proId, 1));
        return Result.success();
    }

    @ApiOperation("取消收藏")
    @PostMapping("/{collectionId}")
    @CachePut
    public Result cancel(@PathVariable String collectionId) {
        Collection collection = service.getById(collectionId);
        collection.setState(0);
        service.saveOrUpdate(collection);
        return Result.success();
    }

    @ApiOperation("查看收藏的商品")
    @GetMapping
    public Result products(HttpServletRequest request) {
        List<Product> products = service.products(request);
        return Result.success(products);
    }
}
