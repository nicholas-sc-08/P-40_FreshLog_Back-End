package com.fl.freshlog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fl.freshlog.dto.ProductDTO;
import com.fl.freshlog.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Tag(name = "Product Endpoint", description = "CRUD of table 'tb_product' where you can find by name, create category, update and delete.")
public class ProductController {
    
    private final ProductService productService;

    @GetMapping("/product")
    @Operation(method = "GET", summary = "Get all the products of database.")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    } 

    @GetMapping("/product/{name}")
    @Operation(method = "GET", summary = "Get a unique product by it's name.")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String name) {
        ProductDTO product = productService.getProductByName(name);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/product")
    @Operation(method = "POST", summary = "Create a new product.")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO dto) {
        ProductDTO product = productService.saveProduct(dto);
        return ResponseEntity.status(201).body(product);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }
}
