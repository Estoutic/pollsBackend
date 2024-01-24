package com.estoutic.pollsbackend.models.category;

import com.estoutic.pollsbackend.models.category.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {

    private String name;
    private CategoryType categoryType;

}
