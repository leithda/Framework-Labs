package cn.leithda.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")  // 执行前验证
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }


    @PreAuthorize("#id < 10 and principal.username.equals(#username) and #user.username.equals('admin')")   // 方法执行前验证
    @PostAuthorize("#returnObject%2 == 0")  // 方法执行后验证
    @RequestMapping("/preAndPostAuthorize")
    public Integer preAndPostAuthorize(Integer id, String username, User user){
        return id;
    }

    @PreFilter("filterObject%2 == 0")   // 过滤参数集合对象
    @PostFilter("filterObject%4 == 0")  // 过滤返回结果集合对象
    @RequestMapping("/preAndPostFilter")
    public List<Integer> preAndPostFilter(List<Integer> idList){
        return idList;
    }


}
