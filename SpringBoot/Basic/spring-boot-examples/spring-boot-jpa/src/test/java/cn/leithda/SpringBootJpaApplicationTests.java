package cn.leithda;

import cn.leithda.entity.User;
import cn.leithda.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class SpringBootJpaApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void findAll(){
        List<User> userList = userService.findAll();
        userList.forEach(System.out::print);
    }

    @Test
    public void updateById(){
        User user = userService.updateById(new User(1L, "mellofly", 25));
        System.out.println(user);
    }

    @Test
    public void addUser(){
        User user = new User(4L,"springboot",25);
        System.out.println(userService.add(user));
    }

    @Test
    public void findAllPageable(){
        // 创建排序条件
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        // 创建分页条件
        Pageable pageable = PageRequest.of(0, 1, sort);

        Page<User> userPage = userService.findAll(pageable);
        userPage.get().forEach(System.out::print);
    }


}
