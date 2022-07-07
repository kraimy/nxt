package com.exam.nxt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.ProductDTO;
import com.exam.nxt.entity.Product;
import com.exam.nxt.service.impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 商品前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Api(tags = "商品接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductServiceImpl service;

    @ApiOperation("查询所有商品")
    @GetMapping
    @Cacheable
    public Result findAll(@Parameter(description = "商品类别id") @RequestParam(defaultValue = "") String cateid,
                          @Parameter(description = "商品名") @RequestParam(defaultValue = "") String name
    ) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if (!cateid.equals("")) wrapper.eq("cateid", cateid);
        if (!name.equals("")) wrapper.eq("name", name);
        return Result.success(service.list(wrapper));
    }

    @ApiOperation("分页")
    @GetMapping("/page")
    @Cacheable
    public Result page(@Parameter(description = "当前页") @RequestParam(defaultValue = "1") int current,
                       @Parameter(description = "每页记录数") @RequestParam(defaultValue = "10") int size,
                       @Parameter(description = "商品类别id") @RequestParam(defaultValue = "") String cateid,
                       @Parameter(description = "商品名") @RequestParam(defaultValue = "") String name
    ) {
        Page<Product> page = new Page<>(current, size);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if (cateid.equals("")) wrapper.eq("cateid", cateid);
        if (name.equals("")) wrapper.eq("name", name);
        page = service.page(page);
        return Result.success(page);
    }

    @ApiOperation("新增或修改商品")
    @PostMapping
    @CachePut
    public Result saveOrUpdate(HttpServletRequest request, @RequestBody Product product) {
        product.setProid(GenerateId.getProductId());
        service.saveOrUpdate(product);
        return Result.success();
    }
    @ApiOperation("通过商品id查询分类")
    @GetMapping("/proId/{proId}")
    @Cacheable
    public Result CategoryByProId(@Parameter(description = "商品id") @PathVariable String proId) {
        return Result.success(service.categoryByProId(proId));
    }

    @ApiOperation("新增在售商品")
    @PostMapping("/put")
    public Result put(HttpServletRequest request,
                      @RequestPart("productDTO") ProductDTO productDTO,
                      @RequestPart("mainImg") MultipartFile[] mainImg,
                      @RequestPart("subImg") MultipartFile[] subImg) {

        return Result.success(service.put(request, productDTO, mainImg, subImg));
    }
}
