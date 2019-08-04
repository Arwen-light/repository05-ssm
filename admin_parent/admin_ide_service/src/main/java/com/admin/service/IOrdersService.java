package com.admin.service;

import com.admin.domain.Orders;

import java.util.List;

public interface IOrdersService  {

    List<Orders> findAll(int page, int size)throws  Exception;
}
