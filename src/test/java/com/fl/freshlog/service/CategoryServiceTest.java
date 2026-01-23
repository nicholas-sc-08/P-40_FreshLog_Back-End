package com.fl.freshlog.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.fl.freshlog.entity.Category;
import com.fl.freshlog.repository.CategoryRepo;

@DataJpaTest
@ActiveProfiles("test")
class CategoryServiceTest {
    
    @Mock
    private CategoryRepo categoryRepo;

    @Autowired
    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create Category sucessfully when everything is OK")
    void createCategory() {
        Category userOne = new Category(null, "random");
        categoryRepo.save(userOne);
    }
}
