package cn.leithda.dao;

import cn.leithda.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 用户 Dao
 */
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate template;

    /**
     * 添加用户
     */
    public int add(User user){
        String sql = "insert into user(id, name, age) values(null, ?, ?)";
        return template.update(sql,user.getName(),user.getAge());
    }

    /**
     * 查找所有用户
     */
    public List<User> findAll() {
        String sql = "select * from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
