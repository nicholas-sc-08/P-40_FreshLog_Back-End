package com.fl.freshlog.repository;

import org.springframework.data.repository.CrudRepository;

import com.fl.freshlog.entity.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer>{
    
}
