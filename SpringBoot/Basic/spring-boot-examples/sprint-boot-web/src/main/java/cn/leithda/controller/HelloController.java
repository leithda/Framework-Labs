package cn.leithda.controller;

import cn.leithda.response.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/5
 * Description: Hello Controller
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<BaseResult> hello(){
        BaseResult result = new BaseResult("00001", "成功", "测试数据");
        return ResponseEntity.ok(result);
    }
}
