package com.exam.nxt.service.impl;

import com.exam.nxt.entity.Address;
import com.exam.nxt.mapper.AddressMapper;
import com.exam.nxt.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-07-03
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
