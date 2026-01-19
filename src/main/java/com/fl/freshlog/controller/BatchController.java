package com.fl.freshlog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fl.freshlog.repository.ProductRepo;
import com.fl.freshlog.service.BatchService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BatchController {
    
    private final BatchService batchService;

}
