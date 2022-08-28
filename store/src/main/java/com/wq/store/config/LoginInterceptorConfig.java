package com.wq.store.config;

import com.wq.store.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description  处理器拦截器的注册，使其生效
 *
 * @author WangQian
 * @create 2022-06-27 21:19
 */
@Configuration   //加载当前的拦截器并进行注册
public class LoginInterceptorConfig implements WebMvcConfigurer {

    //创建自定义的拦截器对象
    HandlerInterceptor interceptor=new LoginInterceptor();


    //将自定义的拦截器进行注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //配置白名单：存放在List集合
        List<String> patterns=new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")   //拦截所有的请求
                .excludePathPatterns(patterns);   //放行的请求
    }
}