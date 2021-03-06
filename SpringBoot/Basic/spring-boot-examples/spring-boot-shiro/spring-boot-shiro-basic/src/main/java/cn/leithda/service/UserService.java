package cn.leithda.service;

import cn.leithda.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: 用户服务接口
 */
public interface UserService {
    User findByUsername(String username);
}
