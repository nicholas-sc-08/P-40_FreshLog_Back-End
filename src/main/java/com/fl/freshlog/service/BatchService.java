package com.fl.freshlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.BatchDTO;
import com.fl.freshlog.entity.Batch;
import com.fl.freshlog.entity.Product;
import com.fl.freshlog.exception.BatchAlreadyExistsException;
import com.fl.freshlog.exception.BatchNotFoundException;
import com.fl.freshlog.exception.ProductNotFoundException;
import com.fl.freshlog.mapper.BatchMapper;
import com.fl.freshlog.repository.BatchRepo;
import com.fl.freshlog.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final ProductRepo productRepo;
    private final BatchRepo batchRepo;
    private final BatchMapper batchMapper;

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
        Optional<BatchDTO> batchExists = batchRepo.findByProductName(dto.productName());
        if(batchExists.isPresent()) {
            throw new BatchAlreadyExistsException("Batch of "+dto.productName()+" already exists");
        }
        
        Batch batch = new Batch();
        batch.setProduct(product);  
        batch.setQuantity(dto.quantity());

        Batch newBatch = batchRepo.save(batch);
        return batchMapper.toDTO(newBatch);
    }

    public void deleteBatch(Integer id) {
        if(batchRepo.findById(id).isEmpty()) {
            throw new BatchNotFoundException("Batch with id "+id+" don't exists.");
        }
        batchRepo.deleteById(id);
    }
}