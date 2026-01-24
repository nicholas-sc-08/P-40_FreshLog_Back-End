package com.fl.freshlog.mapper;

import org.springframework.stereotype.Component;

import com.fl.freshlog.dto.BatchDTO;
import com.fl.freshlog.entity.Batch;

@Component
public class BatchMapper {
    public BatchDTO toDTO(Batch b) {
        return new BatchDTO(
            b.getBatchId(),
            b.getProduct().getName(),
            b.getQuantity()
        );
    }
}
