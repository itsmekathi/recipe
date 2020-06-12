package com.aayud.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();
    }
    @Test
    void getId() {
        Long catId = 4L;
        category.setId((catId));

        assertEquals(catId, category.getId());
    }

    @Test
    void getDescription() {
        String description = "This is a description";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }
}