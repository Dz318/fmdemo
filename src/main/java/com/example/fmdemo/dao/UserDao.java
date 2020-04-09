package com.example.fmdemo.dao;

import com.example.fmdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/***
 * Created by dz on 2020-4-1
 */
@Component
public interface UserDao extends JpaRepository<User,Long> {
    /**
     * update users
     * @param user update's user
     */
    @Modifying
    @Query(value = "update user set user_Name=:#{#user.userName},age=:#{#user.age},address=:#{#user.address},city=:#{#user.city}" +
            " where id=:#{#user.id}",nativeQuery = true)
    int update(@Param("user") User user);

}
