package com.example.assignment2.controllers;

import com.example.assignment2.repositories.CategoryRepository;
import com.example.assignment2.repositories.RecipeRepository;
import com.example.assignment2.repositories.UnitOfMeasuresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasuresRepository unitOfMeasuresRepository;
    private final RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository,
                           UnitOfMeasuresRepository unitOfMeasuresRepository,
                           RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasuresRepository = unitOfMeasuresRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("allrecipe", recipeRepository.findAll());
        return "index";
    }
}
