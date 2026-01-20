package com.fl.freshlog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{
    public Optional<CategoryDTO> findByName(String name);
}
