package com.exam.nxt.service.impl;

import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.ProductDTO;
import com.exam.nxt.entity.Category;
import com.exam.nxt.entity.Product;
import com.exam.nxt.entity.User;
import com.exam.nxt.mapper.CategoryMapper;
import com.exam.nxt.mapper.ProductMapper;
import com.exam.nxt.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.cache.annotation.CachePut;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Resource
    CategoryServiceImpl categoryService;
    @Resource
    UserServiceImpl userService;

    public Category categoryByProId(String proId) {
        Product product = getById(proId);
        return categoryService.getById(product.getCateid());
    }

    //新增在售商品
    @SneakyThrows
    @CachePut
    public Result put(HttpServletRequest request, ProductDTO productDTO, MultipartFile[] mainImgs, MultipartFile[] subImgs) {
        int role = NXTUtils.getRole(userService, NXTUtils.getuid(request));
        if (role == 0) return Result.error("401", "权限不足");
        //主图录目
        String mainPath = NXTUtils.systemPath() + "/files/images/products/main";
        String subPath = NXTUtils.systemPath() + "/files/images/products/sub";
        File mainFile = new File(mainPath);
        File subFile = new File(subPath);
        List mainList = new ArrayList();
        List subList = new ArrayList();
        if (!mainFile.exists()) mainFile.mkdirs();
        if (!subFile.exists()) subFile.mkdirs();
        //存储图片
        for (MultipartFile mainImg : mainImgs) {
            String fileName = UUID.randomUUID().toString() + mainImg.getOriginalFilename().substring(mainImg.getOriginalFilename().lastIndexOf("."));
            mainImg.transferTo(new File(mainPath, fileName));
            mainList.add("/files/images/products/main/" + fileName);
        }
        for (MultipartFile subImg : subImgs) {
            String fileName = UUID.randomUUID().toString() + subImg.getOriginalFilename().substring(subImg.getOriginalFilename().lastIndexOf("."));
            subImg.transferTo(new File(subFile, fileName));
            subList.add("/files/images/products/main/" + fileName);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setProid(GenerateId.getProductId())
                .setMainimage(new JSONArray(mainList).toString())
                .setSubimages(new JSONArray(subList).toString())
                .setCreatetime(LocalDateTime.now())
                .setUpdatetime(LocalDateTime.now());
        return Result.success();
    }
}
