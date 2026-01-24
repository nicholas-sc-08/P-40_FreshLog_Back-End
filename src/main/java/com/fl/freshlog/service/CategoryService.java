package com.fl.freshlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.entity.Category;
import com.fl.freshlog.exception.CategoryAlreadyExistsException;
import com.fl.freshlog.exception.CategoryNotFoundException;
import com.fl.freshlog.mapper.CategoryMapper;
import com.fl.freshlog.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll().stream().map(c -> categoryMapper.toDTO(c)).toList();
    }

    public CategoryDTO getCategoryByName(String name) {
        CategoryDTO existsCategory = categoryRepo.findByName(name).orElseThrow(() -> new CategoryNotFoundException("Category "+name+" don't exists!"));
        return existsCategory;        
    }

    public CategoryDTO saveCategory(CategoryDTO dto) {
        
        if(categoryRepo.findByName(dto.name()).isPresent()) {
           throw new CategoryAlreadyExistsException("Category already exists!");
        }

        Category entity = new Category();
        entity.setName(dto.name());
            
        Category savedEntity = categoryRepo.save(entity);
        return categoryMapper.toDTO(savedEntity);
    }

    public void deleteCategory(Integer id) {
        if(categoryRepo.findById(id).isEmpty()) {
            throw new CategoryNotFoundException("Category with id "+id+" don't exists!");
        }
        categoryRepo.deleteById(id);
    }
}
