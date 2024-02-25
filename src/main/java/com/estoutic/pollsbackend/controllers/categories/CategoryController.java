package com.estoutic.pollsbackend.controllers.categories;

import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.poll.PollDto;
import com.estoutic.pollsbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public String createCategory(@RequestBody() CategoryDto categoryDto) {
        return categoryService.save(categoryDto );
    }

    @GetMapping("/category/{id}")
    public List<PollDto> getAllByCategory(@PathVariable(name = "id") String categoryId){
        return categoryService.getAllByCategory(categoryId);
    }
}
