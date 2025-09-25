package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Recipe;
import com.example.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @RequestMapping("{id}")
  public String detail(@PathVariable("id") int id, Model model) {
    // レシピ詳細 取得
    Recipe recipe = recipeService.getRecipeById(id);
    if (recipe == null) {
      return "error/404";
    }
    model.addAttribute("recipe", recipe);
    
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRecommendRecipeOrderByCreatedDateLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);
    
    return "recipe/detail";
  }
}
