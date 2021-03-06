package cn.leithda.mapper;

import cn.leithda.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/25
 * Description: 用户数据接口
 */
@Mapper
public interface UserMapper {
    User findByUsername(@Param("username")String username);
}
