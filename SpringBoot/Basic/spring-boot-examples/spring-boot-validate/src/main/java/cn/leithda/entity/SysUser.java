package cn.leithda.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 用户实体
 *
 * @author leithda
 * @since 2021/3/15 下午10:50
 */
public class SysUser {

    private Long id;


    @NotBlank(message = "名称不能为空")
    private String name;

    @Email
    private String email;

    @Min(0)
    @Max(150)
    private Integer age;
}
