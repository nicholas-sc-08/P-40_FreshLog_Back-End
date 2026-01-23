package com.fl.freshlog.repository;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import com.fl.freshlog.dto.CategoryDTO;
import com.fl.freshlog.entity.Category;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
class CategoryRepoTest {
    
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Should get category sucessfuly from DB")
    void findByNameCaseOne() {
        CategoryDTO dto = new CategoryDTO(null,"Random");
        createCategory(dto);

        Optional<CategoryDTO> result = categoryRepo.findByName(dto.name());

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get category from DB")
    void findByNameCaseTwo() {
        String name = "Random";
        
        Optional<CategoryDTO> result = categoryRepo.findByName(name);

        assertThat(result.isEmpty()).isTrue();
    }

    private Category createCategory(CategoryDTO dto) {
        Category newCategory = new Category(dto);
        entityManager.persist(newCategory);
        return newCategory;
    }
}
