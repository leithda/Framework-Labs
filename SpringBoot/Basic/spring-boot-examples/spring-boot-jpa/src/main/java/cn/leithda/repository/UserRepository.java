package cn.leithda.repository;

import cn.leithda.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/8
 * Description: 用户 Repository
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long>, JpaRepository<User,Long> {

    // nativeQuery: 是否使用原生Sql，即使用表名拼接sql，而非对象
    @Query(value = "SELECT u FROM User u WHERE u.name = :name", nativeQuery = false)
    User findByName(@Param("name") String name);


    @Query(value = "select u from User u",
    countQuery = "select count(u) from User u")
    Page<User> findUserByPage(Pageable pageable);


}
