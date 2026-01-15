package com.fl.freshlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fl.freshlog.dto.BatchDTO;
import com.fl.freshlog.entity.Batch;
import com.fl.freshlog.entity.Product;
import com.fl.freshlog.repository.BatchRepo;
import com.fl.freshlog.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BathService {
    
    private final ProductRepo productRepo;
    private final BatchRepo batchRepo;

    public List<Batch> findAllBatchs() {
        return batchRepo.findAll();
    }

    public Batch findBatchById(Integer batchId) {
        return batchRepo.findById(batchId).orElseThrow(() -> new RuntimeException("Batch not found with id: "+batchId+"."));
    }

    public Batch saveBatch(BatchDTO dto) {
        Product product = productRepo.findByName(dto.productName()).orElseThrow(() -> new RuntimeException("Product not found with name: "+dto.productName()+"."));
        Batch batch = new Batch();

        batch.setProduct(product);  
        batch.setQuantity(dto.quantity());

        return batchRepo.save(batch);
    }

    public void deleteBatch(Integer id) {
        batchRepo.deleteById(id);
    }
}