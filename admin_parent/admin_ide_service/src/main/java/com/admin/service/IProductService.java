package com.admin.service;

import com.admin.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll() throws  Exception;
}
