package com.admin.service.Impl;

import com.admin.dao.IProductDao;
import com.admin.domain.Product;
import com.admin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//增加的事物的控制
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> lists = iProductDao.findAll();
        return lists;
    }

    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }
}
