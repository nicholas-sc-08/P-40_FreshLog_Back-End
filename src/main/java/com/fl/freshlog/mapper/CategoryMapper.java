package com.fl.freshlog.mapper;

import org.springframework.stereotype.Component;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.entity.Category;

@Component
public class CategoryMapper {
    
    public CategoryDTO toDTO(Category c) {
        return new CategoryDTO(
            c.getCategoryId(),
            c.getName() 
        );
    }
}
