package com.orange.jiang.nan.bootstrap.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xieyong
 * @date 2019/10/30
 * @Description:
 */
@Slf4j
public class BootstrapUserInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //查询用户信息 注入到session中
        log.info(request.getParameterMap().toString());
        return true;
    }
}
