package com.admin.dao;

import com.admin.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

   //查询所有的产品信息
   @Select("select * from product")
    List<Product> findAll() throws Exception;


   @Insert("insert into product " +
           "(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
           " values " +
           "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

   @Select("select * from product where id = #{id}")
    Product findById(String id)throws  Exception;
}
