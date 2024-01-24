package com.estoutic.pollsbackend.database.entities;

import com.estoutic.pollsbackend.database.entities.polls.Poll;
import com.estoutic.pollsbackend.models.category.CategoryDto;
import com.estoutic.pollsbackend.models.category.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "category")
    private Set<Poll> polls;


    public Category(CategoryDto categoryDto) {
        this.polls = new HashSet<>();
        this.name = categoryDto.getName();
        this.categoryType = categoryDto.getCategoryType();
    }

    public void addPoll(Poll poll) {
        this.polls.add(poll);
    }

}
