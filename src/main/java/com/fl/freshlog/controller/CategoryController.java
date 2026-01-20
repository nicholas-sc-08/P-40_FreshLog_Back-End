package com.fl.freshlog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Category Endpoint", description = "CRUD of table 'tb_category' where you can find by name, create category, update and delete.")
public class CategoryController {
    
    private final CategoryService categoryService;

    @Operation(summary = "Get all the categories from the database.")
    @GetMapping("/category")
    public ResponseEntity<?> getAllCategoryies() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @Operation(summary = "Here you get an specific category by it's name.")
    @GetMapping("/category/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String name) {
        CategoryDTO category = categoryService.getCategoryByName(name);
        return ResponseEntity.ok().body(category);
    }

    @Operation(method = "POST & PUT", summary = "Here you will be creating an category, if it exists, have an id and you send to the database, it will update the existing category.")
    @PostMapping("/category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO dto) {
        CategoryDTO category = categoryService.saveCategory(dto);
        return ResponseEntity.status(201).body(category);
    }

    @Operation(method = "DELETE", summary = "Choise which category you want to delete by it's ID.")
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().body("Category delete with success!");
    }
}
