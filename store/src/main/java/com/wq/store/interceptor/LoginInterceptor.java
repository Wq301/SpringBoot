package com.wq.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description   定义一个拦截器
 *          白名单：login.html\register.html\login\reg\index.html\product.html
 *          黑名单：在用户登录之后才可以访问的页面资源
 * @author WangQian
 * @create 2022-06-27 11:03
 */
public class LoginInterceptor implements HandlerInterceptor {

    //检测全局session对象中是否有uid对象，如果有则放行(true)，否则重定向到登录界面(false)
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //HttpServletRequest对象来获取session对象
        Object object = request.getSession().getAttribute("uid");
        if(object==null){
            response.sendRedirect("/web/login.html");
            return false;   //结束后续的调用
        }
        //请求放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}