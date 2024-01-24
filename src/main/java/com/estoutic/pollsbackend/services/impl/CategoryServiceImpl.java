package com.estoutic.pollsbackend.services.impl;

import com.estoutic.pollsbackend.database.entities.Category;
import com.estoutic.pollsbackend.database.repositories.CategoryRepository;
import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public String save(CategoryDto categoryDto) {
        Category category = new Category(categoryDto);
        return categoryRepository.save(category).getId();
    }
}
