package com.fl.freshlog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    public Optional<Product> findByName(String name);
}
