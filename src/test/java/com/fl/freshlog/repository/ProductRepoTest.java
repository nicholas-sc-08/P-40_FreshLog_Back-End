package com.fl.freshlog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepoTest {

    EntityManager entityManager;

    @Test
    void findByName(){

    }
}
