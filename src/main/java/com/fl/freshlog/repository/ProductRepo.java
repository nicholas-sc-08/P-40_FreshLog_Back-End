package com.fl.freshlog.repository;

import org.springframework.data.repository.CrudRepository;

import com.fl.freshlog.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{
    
}
