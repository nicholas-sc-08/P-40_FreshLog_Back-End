package com.fl.freshlog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fl.freshlog.dto.BatchDTO;
import com.fl.freshlog.service.BatchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Batch Endpoint", description = "CRUD table of 'tb_batch' where you can find by ID, create or update or delete.")
public class BatchController {
    
    private final BatchService batchService;
    
    @Operation(summary = "Get all the batchs from the database.")
    @GetMapping("/batch")
    public ResponseEntity<List<BatchDTO>> findAllBatchs() {
        List<BatchDTO> batchs = batchService.findAllBatchs();
        return ResponseEntity.ok().body(batchs);
    }

    @Operation(summary = "Here you get an specific batch by it's id.")
    @GetMapping("/batch/{batchId}")
    public ResponseEntity<BatchDTO> findBatchById(@PathVariable Integer batchId) {
        BatchDTO batch = batchService.findBatchById(batchId);
        return ResponseEntity.ok().body(batch);
    }

    @Operation(method = "POST & PUT", summary = "Here you will be creating an batch, if it exists, have an id and you send to the database, it will update the existing batch.")
    @PostMapping("/batch")
    public ResponseEntity<BatchDTO> saveBatch(@RequestBody BatchDTO dto) {
        BatchDTO batch = batchService.saveBatch(dto);
        return ResponseEntity.status(201).body(batch);
    }

    @Operation(method = "DELETE", summary = "Choise which batch you want to delete by it's ID.")
    @DeleteMapping("/batch/{batchId}")
    public ResponseEntity<?> deleteBatchById(@PathVariable Integer batchId) {
        batchService.deleteBatch(batchId);
        return ResponseEntity.ok().build();
    }
}
