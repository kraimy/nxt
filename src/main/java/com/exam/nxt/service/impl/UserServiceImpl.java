package com.exam.nxt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.nxt.common.GenerateId;
import com.exam.nxt.common.Result;
import com.exam.nxt.dto.WeChatModel;
import com.exam.nxt.entity.User;
import com.exam.nxt.mapper.UserMapper;
import com.exam.nxt.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.nxt.utils.JWTUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 用户服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-06-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    //一键登录
    public Result loginOrRegister(WeChatModel weChatModel) {
        String phone = weChatModel.getPhone();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", phone);
        List<User> users = list(wrapper);
        //如果查不到普通用户，则进行普通用户注册返回token
        if (users.size() == 0) {
            User user = new User(GenerateId.getUserid(), phone, 1, LocalDateTime.now(), LocalDateTime.now());
            saveOrUpdate(user);
            Map map=new HashMap();
            map.put("token",JWTUtils.getToken(user));
            map.put("id",user.getUserid());
            return Result.success(map);
        }
        //如果查到用户验证用户权限 进行登录,返回token
        List<User> usersCheck = new ArrayList<>();
        for (User user : users) {
            if (user.getRole() == 1) {
                usersCheck.add(user);
            }
        }
        if (usersCheck.size() == 1) {
            Map map=new HashMap();
            map.put("token",JWTUtils.getToken(usersCheck.get(0)));
            map.put("id",usersCheck.get(0).getUserid());
            return Result.success(map);
        } else {
            return Result.error("500", "登录失败,请联系管理员！");
        }
    }
}
