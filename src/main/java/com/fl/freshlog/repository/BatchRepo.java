package com.fl.freshlog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.entity.Batch;

@Repository
public interface BatchRepo extends CrudRepository<Batch, Integer>{
    
}
