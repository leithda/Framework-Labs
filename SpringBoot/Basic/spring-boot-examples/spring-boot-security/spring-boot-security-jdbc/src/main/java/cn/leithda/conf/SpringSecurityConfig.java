package cn.leithda.conf;

import cn.leithda.service.SecurityUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: Spring Security 配置
 */

@Configuration
@EnableWebSecurity  // 开启Security安全验证
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 开启方法级验证
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Autowired
    SecurityUserDetailsServiceImpl userDetailsService;

    // 注入PasswordEncoder，避免SpringSecurity验证密码报错：java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用数据库加载用户权限信息
        auth.userDetailsService(userDetailsService);

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from users WHERE username=?")
                .authoritiesByUsernameQuery("select username,authority from authorities where username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()   // 允许访问项目根路径
                .anyRequest().authenticated()   // 其他路径进行认证
                .and()
                .logout().permitAll()   // 允许登出
                .and()
                .formLogin().permitAll();   // 允许表单登录

        http.cors().disable();  // 关闭Cors认证

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/img/**");   // 静态资源不进行拦截
    }
}
