package com.fl.freshlog.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductDTO(
    Integer productId,
    String name,
    String categoryName,
    BigDecimal price,
    Integer minStock,
    LocalDate createdAt
) {}
