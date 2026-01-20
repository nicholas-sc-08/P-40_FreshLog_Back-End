package com.fl.freshlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.BatchDTO;
import com.fl.freshlog.entity.Batch;
import com.fl.freshlog.entity.Product;
import com.fl.freshlog.exception.BatchNotFoundException;
import com.fl.freshlog.exception.ProductNotFoundException;
import com.fl.freshlog.repository.BatchRepo;
import com.fl.freshlog.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final ProductRepo productRepo;
    private final BatchRepo batchRepo;

    public List<BatchDTO> findAllBatchs() {
        List<Batch> batches = batchRepo.findAll();
        return batches.stream().map(batch -> new BatchDTO(batch.getBatchId(), batch.getProduct().getName(), batch.getQuantity())).toList();
    }

    public BatchDTO findBatchById(Integer batchId) {
        Batch batch = batchRepo.findById(batchId).orElseThrow(() -> new BatchNotFoundException("Batch not found with id: "+batchId+"."));
        BatchDTO dto = new BatchDTO(batch.getBatchId(), batch.getProduct().getName(), batch.getQuantity());
        return dto;
    }

    public BatchDTO saveBatch(BatchDTO dto) {
        Product product = productRepo.findByName(dto.productName()).orElseThrow(() -> new ProductNotFoundException("Product not found with name: "+dto.productName()+"."));
        Batch batch = new Batch();

        batch.setProduct(product);  
        batch.setQuantity(dto.quantity());

        Batch newBatch = batchRepo.save(batch);
        BatchDTO response = new BatchDTO(newBatch.getBatchId(), newBatch.getProduct().getName(), newBatch.getQuantity());
        return response;
    }

    public void deleteBatch(Integer id) {
        batchRepo.deleteById(id);
    }
}