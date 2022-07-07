package com.exam.nxt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.entity.Category;
import com.exam.nxt.entity.Product;
import com.exam.nxt.mapper.CategoryMapper;
import com.exam.nxt.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Service
@SuppressWarnings("all")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Resource
    ProductServiceImpl productService;

    public List<Product> productByCateId(String cateId) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("cateid", cateId);
        return productService.list(wrapper);
    }
}
