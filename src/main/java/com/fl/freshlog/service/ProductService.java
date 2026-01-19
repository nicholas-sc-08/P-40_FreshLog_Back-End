package com.fl.freshlog.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.dto.ProductDTO;
import com.fl.freshlog.entity.Category;
import com.fl.freshlog.entity.Product;
import com.fl.freshlog.exception.CategoryNotFoundException;
import com.fl.freshlog.exception.ProductNotFoundException;
import com.fl.freshlog.repository.CategoryRepo;
import com.fl.freshlog.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductDTO getProductByName(String name) {
        Product product = productRepo.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product with name "+name+" don't exist"));
        Category category = categoryRepo.findById(product.getCategory().getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Category with name "+name+" not found"));

        ProductDTO productData = new ProductDTO(
            product.getProductId(),
            product.getName(),
            category.getName(),
            product.getPrice(),
            product.getMinStock(),
            product.getCreatedAt()
        );

        return productData;
    }

    public ProductDTO saveProduct(ProductDTO product) {
        CategoryDTO category = categoryRepo.findByName(product.categoryName());

        Product productData = new Product();
        Category categoryEntity = new Category();

        categoryEntity.setCategoryId(category.categoryId());
        categoryEntity.setName(category.name());

        productData.setName(product.name());
        productData.setCategory(categoryEntity);
        productData.setPrice(product.price());
        productData.setMinStock(product.minStock());
        productData.setCreatedAt(product.createdAt());

        Product savedProduct = productRepo.save(productData);

        return new ProductDTO(
            savedProduct.getProductId(), 
            savedProduct.getName(), 
            product.categoryName(), 
            savedProduct.getPrice(), 
            savedProduct.getMinStock(),
            savedProduct.getCreatedAt()
        );
    }
}
