package cn.leithda.conf;

import cn.leithda.web.TimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: Mvc配置类
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public TimeInterceptor timeInterceptor(){
        return new TimeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(this.timeInterceptor());
        registration.addPathPatterns("/**");    // 添加拦截路径
        registration.excludePathPatterns(
                "/login",
                "/**/*.js",
                "/**/*.css",
                "/**/*.ttf");   // 添加排除路径
    }

    /**
     * CORS 跨域问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加全局的 CORS 配置
        registry.addMapping("/**") // 匹配所有 URL ，相当于全局配置
                .allowedOrigins("*") // 允许所有请求来源
                .allowCredentials(true) // 允许发送 Cookie
                .allowedMethods("*") // 允许所有请求 Method
                .allowedHeaders("*") // 允许所有请求 Header
                .maxAge(1800L); // 有效期 1800 秒，2 小时
    }
}
