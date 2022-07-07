package com.exam.nxt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.entity.Collection;
import com.exam.nxt.entity.Product;
import com.exam.nxt.mapper.CollectionMapper;
import com.exam.nxt.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.nxt.utils.NXTUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-07-04
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {
    @Resource
    ProductServiceImpl productService;

    @Cacheable
    public List<Product> products(HttpServletRequest request) {
        String uid = NXTUtils.getuid(request);
        QueryWrapper<Collection> collectionQueryWrapper = new QueryWrapper<>();
        collectionQueryWrapper.eq("user_id", uid);
        List<Collection> collections = this.list(collectionQueryWrapper);
        List ids = new ArrayList();
        for (Collection collection : collections) {
            ids.add(collection.getProId());
        }
        List<Product> products = productService.listByIds(ids);
        return products;
    }
}
