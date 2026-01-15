package com.fl.freshlog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.entity.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer>{
    
}
