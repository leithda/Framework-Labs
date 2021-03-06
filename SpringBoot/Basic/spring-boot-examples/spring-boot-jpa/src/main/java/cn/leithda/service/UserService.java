package cn.leithda.service;

import cn.leithda.entity.PageInfo;
import cn.leithda.entity.User;
import cn.leithda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User updateById(User user){
        return userRepository.save(user);
    }

    public User add(User user){
        return userRepository.save(user);
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }


}
