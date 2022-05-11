package com.example.assignment2.controllers;

import com.example.assignment2.repositories.CategoryRepository;
import com.example.assignment2.repositories.UnitOfMeasuresRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasuresRepository unitOfMeasuresRepository;

    public IndexController(CategoryRepository categoryRepository,
                           UnitOfMeasuresRepository unitOfMeasuresRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasuresRepository = unitOfMeasuresRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }
}
