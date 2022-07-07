package com.exam.nxt.config.interceptor;

import com.exam.nxt.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        //验证是否存在
        if (token==null) return false;
        //验证是否有效
        if (!JWTUtils.verify(token)) return false;
        //中间写逻辑代码，比如判断是否登录成功，失败则返回false
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //
        //System.out.println("controller 执行完了");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //System.out.println("我获取到了一个返回的结果："+response);
        //System.out.println("请求结束了");
    }
}

