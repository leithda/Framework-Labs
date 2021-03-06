package cn.leithda.controller;

import cn.leithda.pojo.User;
import cn.leithda.response.BaseResult;
import cn.leithda.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(value = "用户模块", tags = "用户接口API")
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    @ApiOperation(value = "用户列表", notes = "无条件查询所有用户信息")
    public ResponseEntity<BaseResult> findAll() {
        List<User> userList = userService.findAll();
        BaseResult result = BaseResult.success(userList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个用户", notes = "根据用户Id获取用户信息")
    public ResponseEntity<BaseResult> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        BaseResult result;
        if (user != null) {
            result = BaseResult.success(user);
        } else {
            result = BaseResult.error("200001001", "查询用户不存在");
        }
        return ResponseEntity.ok(result);
    }
}
