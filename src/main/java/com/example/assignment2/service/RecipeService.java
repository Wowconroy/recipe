package com.example.assignment2.service;

import com.example.assignment2.domain.Recipe;
import com.example.assignment2.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> getAllRecipe(){
//        Set<Recipe> recipes = new HashSet<>();
//        repository.findAll().iterator().forEachRemaining(recipes::add);

        Iterable<Recipe> all = repository.findAll();
        List<Recipe> recipeList = StreamSupport
                .stream(all.spliterator(), false)
                .collect(Collectors.toList());
        return recipeList;
    }
}
