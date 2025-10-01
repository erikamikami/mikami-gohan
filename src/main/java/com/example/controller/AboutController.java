package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Recipe;
import com.example.service.RecipeService;

@Controller
@RequestMapping("/about")
public class AboutController {
  
  @Autowired
  private RecipeService recipeService;
  
  @RequestMapping("")
  public String index(Model model) {
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRecommendRecipeOrderByCreatedDateLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);
    return "about/index";
  }
}
