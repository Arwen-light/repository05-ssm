package com.admin.service.Impl;

import com.admin.dao.IOrdersDao;
import com.admin.domain.Orders;
import com.admin.domain.Product;
import com.admin.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        // 分页内容
       PageHelper.startPage(page,size);
        List<Orders> ordersList = iOrdersDao.findAll();
        return ordersList;
    }


    // 根据 orders --> id 进行某个订单信息查询
    @Override
    public Orders findById(String id) throws Exception {

        Orders order = iOrdersDao.findById(id);
        return order;
    }
}
