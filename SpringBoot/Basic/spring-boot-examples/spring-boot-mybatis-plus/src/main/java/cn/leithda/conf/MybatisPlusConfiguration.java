package cn.leithda.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: Mybatis Plus 配置
 */
@Configuration
@MapperScan("cn.leithda.mapper")
public class MybatisPlusConfiguration {
}
