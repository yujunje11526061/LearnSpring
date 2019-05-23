package com.utils;


import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class MyInterceptor implements HandlerInterceptor {


    /**
     * 拦截的核心方法，返回false则代表拒绝访问，不会调用handler，也就不会执行另外两个方法，返回true则允许访问。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Intercept the execution of a handler. Called after HandlerMapping determined an appropriate handler object, but before HandlerAdapter invokes the handler.");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Intercept the execution of a handler. Called after HandlerAdapter actually invoked the handler, but before the DispatcherServlet renders the view.");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception{
        System.out.println("Callback after completion of request processing, that is, after rendering the view. Will be called on any outcome of handler execution, thus allows for proper resource cleanup");
    }
}
