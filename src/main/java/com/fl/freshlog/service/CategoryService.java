package com.fl.freshlog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

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
        CategoryDTO existsCategory = categoryRepo.findByName(name);

        if(existsCategory != null) {
            return existsCategory;
        }
        throw new CategoryNotFoundException("Category "+name+" don't exists!");
    }

    public CategoryDTO saveCategory(CategoryDTO dto) {
        
        CategoryDTO existsCategory = categoryRepo.findByName(dto.name());

        if(existsCategory == null) {
            
            Category entity = new Category();
            entity.setName(dto.name());
            
            Category savedEntity = categoryRepo.save(entity);
            return new CategoryDTO(savedEntity.getCategoryId(), savedEntity.getName());
        }
        throw new CategoryAlreadyExistsException("Category already exists!");
    }

    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }
}
