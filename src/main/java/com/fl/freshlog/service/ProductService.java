package com.fl.freshlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.dto.ProductDTO;
import com.fl.freshlog.entity.Category;
import com.fl.freshlog.entity.Product;
import com.fl.freshlog.exception.ProductAlreadyExistsException;
import com.fl.freshlog.exception.ProductNotFoundException;
import com.fl.freshlog.repository.CategoryRepo;
import com.fl.freshlog.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(p -> new ProductDTO(
            p.getProductId(),
            p.getName(),
            p.getCategory().getName(),
            p.getPrice(),
            p.getMinStock(),
            p.getCreatedAt()
        )).toList();
    }

    public ProductDTO getProductByName(String name) {
        Product product = productRepo.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product with name "+name+" don't exist"));

        ProductDTO productData = new ProductDTO(
            product.getProductId(),
            product.getName(),
            product.getCategory().getName(),
            product.getPrice(),
            product.getMinStock(),
            product.getCreatedAt()
        );

        return productData;
    }

    public ProductDTO saveProduct(ProductDTO dto) {
        CategoryDTO category = categoryRepo.findByName(dto.categoryName());
        Category categoryEntity = new Category();
        
        categoryEntity.setCategoryId(category.categoryId());
        categoryEntity.setName(category.name());

        Product productData = new Product();
        productRepo.findByName(dto.name()).orElseThrow(() -> new ProductAlreadyExistsException("Product with name "+dto.name()+"already exists!"));

        productData.setName(dto.name());
        productData.setCategory(categoryEntity);
        productData.setPrice(dto.price());
        productData.setMinStock(dto.minStock());
        productData.setCreatedAt(dto.createdAt());

        Product savedProduct = productRepo.save(productData);

        return new ProductDTO(
            savedProduct.getProductId(), 
            savedProduct.getName(), 
            savedProduct.getCategory().getName(), 
            savedProduct.getPrice(), 
            savedProduct.getMinStock(),
            savedProduct.getCreatedAt()
        );
    }

    public void deleteProductById(Integer productId) {
        productRepo.deleteById(productId);
    }
}
