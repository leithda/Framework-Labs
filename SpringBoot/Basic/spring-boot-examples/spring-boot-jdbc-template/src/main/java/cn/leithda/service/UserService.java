package cn.leithda.service;

import cn.leithda.dao.UserDao;
import cn.leithda.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 用户 Service
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public int add(User user){
        return userDao.add(user);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
