package com.example.assignment2.service;

import com.example.assignment2.domain.Recipe;
import com.example.assignment2.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    RecipeService underTest;

    @Mock
    RecipeRepository repository;

    Recipe recipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        underTest = new RecipeService(repository);
        recipe = new Recipe();
    }

    @Test
    public void getAllRecipe() {
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(repository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = underTest.getAllRecipe();

        assertEquals(recipes.size(), 1);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void canGetById() {
        Long id = 1L;
        HashSet<Recipe> recipes = new HashSet<>();
        recipe.setId(id);
        recipes.add(recipe);

        when(repository.findById(id)).thenReturn(Optional.of(recipe));

        assertEquals(id, recipe.getId());

        when(repository.findById(id).isEmpty()).thenThrow(RuntimeException.class);
    }

    @Test
    public void ifEmpty() {
        Long id = 10L;
        given(repository.findById(anyLong())).willReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.findById(id))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Recipe not found");
    }
}