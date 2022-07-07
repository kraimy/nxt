package com.exam.nxt.utils;

import com.exam.nxt.entity.User;
import com.exam.nxt.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;


public class NXTUtils {
    //权限获取
    public static int getRole(UserServiceImpl service, String uid) {
        User user = service.getById(uid);
        return user.getRole();
    }

    //controller中获取token的uid
    public static String getuid(HttpServletRequest request) {
        String token = request.getHeader("token");
        String uid = JWTUtils.getTokenInfoId(token);
        return uid;
    }

    public static String systemPath() {
        return System.getProperty("user.dir");
    }

}
