package com.admin.dao;

import com.admin.domain.Member;
import com.admin.domain.Orders;
import com.admin.domain.Product;
import org.apache.ibatis.annotations.*;
/*
id,
ordernum,
ordertime,
peoplecount,
orderdesc,
paytype,
orderstatus,
productid,
memberid


 @Select("select * from orders")
    @Results({


            @Result(property = "product",column = "productId",
            javaType = Product.class,
            one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
    })
 */
import java.util.List;

public interface IOrdersDao {
    @Select("select * from Orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productid",
                    javaType = Product.class,
                    one = @One(select = "com.admin.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;


    // 根据Id 查询有订单的所有信息
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productid",
                    javaType = Product.class,
                    one = @One(select = "com.admin.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberid",
                    javaType = Member.class,
                    one = @One(select = "com.admin.dao.IMemberDao.findByMemberId")),
            @Result(property = "travellers", column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select ="com.admin.dao.ITravellerDao.findByOrderId")),
    })
    Orders findById(String id) throws Exception;

}
