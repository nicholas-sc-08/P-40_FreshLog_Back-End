package com.fl.freshlog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fl.freshlog.service.BatchService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Batch Endpoint", description = "CRUD table of 'tb_batch' where you can find by ID, create or update or delete.")
public class BatchController {
    
    private final BatchService batchService;
    
}
