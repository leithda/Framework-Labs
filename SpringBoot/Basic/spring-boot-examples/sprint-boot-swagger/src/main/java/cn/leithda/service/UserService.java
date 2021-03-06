package cn.leithda.service;

import cn.leithda.pojo.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 用户服务
 */
@Service
public class UserService implements InitializingBean {

    List<User> safeUserList = Collections.synchronizedList(new ArrayList<>());

    public List<User> findAll() {
        return this.safeUserList;
    }

    public User findUserById(Long id) {
        return this.safeUserList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.safeUserList.add(User.builder().id(1L).username("test").email("test@123.com").build());
        this.safeUserList.add(User.builder().id(2L).username("admin").email("admin@123.com").build());
        this.safeUserList.add(User.builder().id(3L).username("leithda").email("leithda@123.com").build());
    }
}
