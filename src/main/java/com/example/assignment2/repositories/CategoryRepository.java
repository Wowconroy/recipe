package com.example.assignment2.repositories;

import com.example.assignment2.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category>findByDescription(String description);
}
