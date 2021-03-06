package cn.leithda.controller;

import cn.leithda.entity.User;
import cn.leithda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 用户 Controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public int addUser(@RequestBody User user){
        return userService.add(user);
    }
}
