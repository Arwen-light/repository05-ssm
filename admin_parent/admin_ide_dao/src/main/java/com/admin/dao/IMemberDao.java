package com.admin.dao;

import com.admin.domain.Member;
import com.admin.domain.Product;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id = #{id} ")
    Member findByMemberId(String id)throws  Exception;
}
