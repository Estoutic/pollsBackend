package com.estoutic.pollsbackend.services;

import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.poll.PollDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    String save(CategoryDto categoryDto);

    List<PollDto> getAllByCategory(String categoryId);

}
