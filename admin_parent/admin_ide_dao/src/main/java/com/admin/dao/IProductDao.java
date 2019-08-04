package com.admin.dao;

import com.admin.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

   //查询所有的产品信息
   @Select("select * from product")
    List<Product> findAll() throws Exception;
}
