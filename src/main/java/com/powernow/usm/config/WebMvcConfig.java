package com.powernow.usm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: swaggerui web页面显示配置
 * @create: 2021-03-20 14:00:00
 * @update: 2021-03-20 14:00:00
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    // 接口拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录验证过滤器 拦截用户请求
//        registry.addInterceptor(getAuthorizationInterceptor())
//                .addPathPatterns("/usm-assets/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 拦截器对象必须加入spring容器，才能在拦截器内注入其他引用的bean
     * @return
     */
//    @Bean
//    public AuthorizationInterceptor getAuthorizationInterceptor(){
//        return new AuthorizationInterceptor();
//    }
}


