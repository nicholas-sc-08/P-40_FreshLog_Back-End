package com.fl.freshlog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.dto.ErrorMessage;
import com.fl.freshlog.exception.CategoryNotFoundException;
import com.fl.freshlog.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    
    private final CategoryService categoryService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getAllCategories(@PathVariable String name) {
        try {
            CategoryDTO category = categoryService.getCategoryByName(name);
            return ResponseEntity.ok().body(category);
            
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
    }
}
