package com.fl.freshlog.dto;

public record BatchDTO(
    Integer batchId,
    String productName,
    Integer quantity
) {}