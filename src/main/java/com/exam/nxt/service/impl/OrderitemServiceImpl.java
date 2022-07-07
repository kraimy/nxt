package com.exam.nxt.service.impl;

import com.exam.nxt.entity.Orderitem;
import com.exam.nxt.mapper.OrderitemMapper;
import com.exam.nxt.service.IOrderitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Service
public class OrderitemServiceImpl extends ServiceImpl<OrderitemMapper, Orderitem> implements IOrderitemService {

}
