package com.fl.freshlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.entity.Category;
import com.fl.freshlog.exception.CategoryAlreadyExistsException;
import com.fl.freshlog.exception.CategoryNotFoundException;
import com.fl.freshlog.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepo categoryRepo;

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(category -> new CategoryDTO(category.getCategoryId(), category.getName())).toList();
    }

    public CategoryDTO getCategoryByName(String name) {
        CategoryDTO existsCategory = categoryRepo.findByName(name).orElseThrow(() -> new CategoryNotFoundException("Category "+name+" don't exists!"));
        return existsCategory;        
    }

    public CategoryDTO saveCategory(CategoryDTO dto) {
        
        categoryRepo.findByName(dto.name()).orElseThrow(() -> new CategoryAlreadyExistsException("Category already exists!"));
            
        Category entity = new Category();
        entity.setName(dto.name());
            
        Category savedEntity = categoryRepo.save(entity);
        return new CategoryDTO(savedEntity.getCategoryId(), savedEntity.getName());
    }

    public void deleteCategory(Integer id) {
        if(!categoryRepo.findById(id).isPresent()) {
            throw new CategoryNotFoundException("Category with id "+id+" don't exists!");
        }
        categoryRepo.deleteById(id);
    }
}
