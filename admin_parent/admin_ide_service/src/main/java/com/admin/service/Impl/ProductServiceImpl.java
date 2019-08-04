package com.admin.service.Impl;

import com.admin.dao.IProductDao;
import com.admin.domain.Product;
import com.admin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> lists = iProductDao.findAll();
        return lists;
    }
}
