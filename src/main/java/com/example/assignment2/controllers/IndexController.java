package com.example.assignment2.controllers;

import com.example.assignment2.repositories.CategoryRepository;
import com.example.assignment2.repositories.RecipeRepository;
import com.example.assignment2.repositories.UnitOfMeasuresRepository;
import com.example.assignment2.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getAllRecipe());
        return "index";
    }
}
