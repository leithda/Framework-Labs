package cn.leithda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"cn.leithda.mapper"})
public class SpringBootShiroBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiroBasicApplication.class, args);
    }

}
