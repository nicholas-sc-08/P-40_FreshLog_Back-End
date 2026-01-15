package com.fl.freshlog.repository;

import org.springframework.data.repository.CrudRepository;

import com.fl.freshlog.entity.Batch;

public interface BatchRepo extends CrudRepository<Batch, Integer>{
    
}
