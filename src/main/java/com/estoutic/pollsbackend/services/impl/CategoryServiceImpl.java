package com.estoutic.pollsbackend.services.impl;

import com.estoutic.pollsbackend.database.entities.Category;
import com.estoutic.pollsbackend.database.entities.polls.Poll;
import com.estoutic.pollsbackend.database.repositories.CategoryRepository;
import com.estoutic.pollsbackend.database.repositories.polls.PollRepository;
import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.services.CategoryService;
import com.estoutic.pollsbackend.services.exceptions.category.CategoryDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final PollRepository pollRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository, PollRepository pollRepository) {

        this.categoryRepository = categoryRepository;
        this.pollRepository = pollRepository;
    }

    @Override
    public String save(CategoryDto categoryDto) {
        Category category = new Category(categoryDto);
        return categoryRepository.save(category).getId();
    }

    @Override
    public List<PollDto> getAllByCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(CategoryDoesNotExistException::new);

        List<Poll> polls = pollRepository.findAllByCategory(category);
        return polls.stream().map(PollDto::new).toList();
    }
}
