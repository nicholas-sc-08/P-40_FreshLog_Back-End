package com.fl.freshlog.mapper;

import org.springframework.stereotype.Component;

import com.fl.freshlog.dto.ProductDTO;
import com.fl.freshlog.entity.Product;

@Component
public class ProductMapper {
    
    public ProductDTO toDTO(Product p) {
        return new ProductDTO(
            p.getProductId(),
            p.getName(),
            p.getCategory().getName(),
            p.getPrice(),
            p.getMinStock(),
            p.getCreatedAt()
        );
    }
}
