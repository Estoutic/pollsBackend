package com.estoutic.pollsbackend.controllers.categories;

import com.estoutic.pollsbackend.models.category.CategoryDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PostMapping("/create")
    public String createCategory(@RequestBody()CategoryDto categoryDto){
        return categoryDto.getName();
    }
}
