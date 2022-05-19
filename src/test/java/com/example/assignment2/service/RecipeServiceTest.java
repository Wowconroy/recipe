package com.example.assignment2.service;

import com.example.assignment2.domain.Recipe;
import com.example.assignment2.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeService(repository);
    }

    @Test
    public void getAllRecipe() {
        Recipe recipe = new Recipe();
        HashSet <Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(repository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getAllRecipe();

        assertEquals(recipes.size(), 1);
        verify(repository, times(1)).findAll();
    }
}