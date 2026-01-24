package com.fl.freshlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.dto.ProductDTO;
import com.fl.freshlog.entity.Category;
import com.fl.freshlog.entity.Product;
import com.fl.freshlog.exception.CategoryNotFoundException;
import com.fl.freshlog.exception.InvalidStockException;
import com.fl.freshlog.exception.ProductAlreadyExistsException;
import com.fl.freshlog.exception.ProductNotFoundException;
import com.fl.freshlog.mapper.ProductMapper;
import com.fl.freshlog.repository.CategoryRepo;
import com.fl.freshlog.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private final CategoryRepo categoryRepo;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(p -> productMapper.toDTO(p)).toList();
    }

    public ProductDTO getProductByName(String name) {
        Product product = productRepo.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product with name "+name+" don't exist"));
        return productMapper.toDTO(product);
    }

    public ProductDTO saveProduct(ProductDTO dto) {
        CategoryDTO category = categoryRepo.findByName(dto.categoryName()).orElseThrow(() -> new CategoryNotFoundException("Category with name "+dto.categoryName()+" don't exists."));
        Category categoryEntity = new Category();
        categoryEntity.setCategoryId(category.categoryId());
        categoryEntity.setName(category.name());

        if(dto.minStock() < 1) {
            throw new InvalidStockException("Stock needs to have at least 1 product.");
        }
        
        Product productData = new Product();
        if(dto.productId() != null && productRepo.existsById(dto.productId())) {
            productData.setProductId(dto.productId());
        } else {
            if(productRepo.findByName(dto.name()).isPresent()) {
                throw new ProductAlreadyExistsException("Product with name "+dto.name()+" already exists");
            }
        }

        productData.setName(dto.name());
        productData.setCategory(categoryEntity);
        productData.setPrice(dto.price());
        productData.setMinStock(dto.minStock());
        productData.setCreatedAt(dto.createdAt());

        Product savedProduct = productRepo.save(productData);

        return productMapper.toDTO(savedProduct);
    }

    public void deleteProductById(Integer productId) {
        if(!productRepo.existsById(productId)){
            throw new ProductNotFoundException("Product with ID "+productId+" don't exists.");
        }
        productRepo.deleteById(productId);
    }
}
