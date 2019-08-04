package com.admin.dao;

import com.admin.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {


    @Select("select * from role where id in (select roleid from users_role where userid = #{userid})")
    List<Role> findRolesByUserId(String userid) throws  Exception;
}
