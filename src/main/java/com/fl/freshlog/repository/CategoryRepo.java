package com.fl.freshlog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.entity.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer>{
    
}
