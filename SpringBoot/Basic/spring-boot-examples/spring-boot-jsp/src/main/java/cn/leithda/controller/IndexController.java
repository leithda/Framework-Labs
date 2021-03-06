package cn.leithda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: 控制器
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        map.put("name","leithda");
        return "index";
    }
}
