package com.admin.dao;

import com.admin.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleDao {


    @Select("select * from role where id in (select roleid from users_role where userid = #{userid})")

    @Results({

            @Result(id= true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(
                    property = "permissions",
                    javaType = java.util.List.class,
                    column = "id",
                    many =@Many(select = "com.admin.dao.IPermissionDao.findByRoleId")
            )
    })
    List<Role> findRolesByUserId(String userid) throws  Exception;


    @Select("select * from role")
    List<Role> findAll() throws  Exception;


    @Insert("insert into Role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;
}
