package com.estoutic.pollsbackend.database.entities;

import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.category.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Getter
public class Category {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;


    public Category(CategoryDto categoryDto) {
        this.name = categoryDto.getName();
        this.categoryType = categoryDto.getCategoryType();
    }

}
