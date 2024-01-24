package com.estoutic.pollsbackend.database.repositories;

import com.estoutic.pollsbackend.database.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
