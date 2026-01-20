package com.fl.freshlog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.dto.BatchDTO;
import com.fl.freshlog.entity.Batch;

@Repository
public interface BatchRepo extends JpaRepository<Batch, Integer>{
    public Optional<BatchDTO> findByProductName(String name);
}
