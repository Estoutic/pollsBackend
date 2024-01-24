package com.estoutic.pollsbackend.services;

import com.estoutic.pollsbackend.models.category.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    String save(CategoryDto categoryDto);
}
