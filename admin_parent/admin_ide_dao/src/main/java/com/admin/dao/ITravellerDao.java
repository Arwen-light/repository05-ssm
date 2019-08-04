package com.admin.dao;

import com.admin.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {


    @Select("select *  from traveller where id in ( select travellerid from order_traveller where orderid = #{id})")
    List<Traveller> findByOrderId(String id) throws  Exception;
}
