package com.fl.freshlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.entity.Batch;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer>{
    
}
