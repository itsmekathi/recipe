package com.aayud.recipe.controllers;

import com.aayud.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class HomeController {
    private final RecipeService recipeService;

    public HomeController( RecipeService recipeService) {

        this.recipeService = recipeService;
    }

    @RequestMapping({"","/"})
    public String index(Model model){
        log.debug("In index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        System.out.println("Completed rendering UI");
        return "index";
    }
}
