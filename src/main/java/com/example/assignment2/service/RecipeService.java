package com.example.assignment2.service;

import com.example.assignment2.domain.Recipe;
import com.example.assignment2.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Set<Recipe> getAllRecipe(){
//        Set<Recipe> recipes = new HashSet<>();
//        repository.findAll().iterator().forEachRemaining(recipes::add);

        log.debug("In the service");

        Iterable<Recipe> all = repository.findAll();
        Set<Recipe> recipeList = StreamSupport
                .stream(all.spliterator(), false)
                .collect(Collectors.toSet());
        return recipeList;
    }
}
