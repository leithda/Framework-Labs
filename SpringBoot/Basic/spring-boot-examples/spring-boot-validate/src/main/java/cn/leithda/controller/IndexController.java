package cn.leithda.controller;

import cn.leithda.entity.SysUser;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * 测试控制器
 *
 * @author leithda
 * @since 2021/3/15 下午10:50
 */

@Validated
@RestController
public class IndexController {

    /**
     * 手动校验
     * @param name 名称
     */
    @GetMapping("/test1")
    public String paramValidate(String name) {
        if(name == null || "".equals(name)){
            throw new RuntimeException("名字不能为空");
        }
        return "success";
    }

    /**
     * 参数校验
     * @param name 名称
     */
    @GetMapping("/test2")
    public String test2(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间") String name) {
        return "success";
    }

    /**
     * 实体类校验
     * @param sysUser 实体类参数
     */
    @GetMapping("/test3")
    public String test3(@Validated SysUser sysUser){
        return "success";
    }

}
