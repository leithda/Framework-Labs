package cn.leithda.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: 测试控制器
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")  // 方法需要ADMIN权限
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}
