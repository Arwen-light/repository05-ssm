package com.admin.dao;

import com.admin.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {


    @Select("select * from users where username = #{username}")
    @Results({
            @Result (id = true,property ="id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.admin.dao.IRoleDao.findRolesByUserId")
            ),
    })
    UserInfo findUserByUserName(String username) throws  Exception;


    @Select("select * from users")
    List<UserInfo> findAll() throws  Exception;


    @Insert("insert into users (email,username,password,phoneNum,status) values " +
            "(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo)throws Exception;


    @Select("select * from users where id = #{id}")
    @Results({
            @Result (id = true,property ="id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.admin.dao.IRoleDao.findRolesByUserId")
            ),
    })
    UserInfo findById(String id)throws Exception;
}
