package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Category;
import com.example.entity.Recipe;
import com.example.service.CategoryService;
import com.example.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

  @Autowired
  private RecipeService recipeService;
  
  @Autowired
  private CategoryService categoryService;

  @RequestMapping("{idString}")
  public String detail(@PathVariable("idString") String idString, Model model) {
    // レシピ詳細 取得
    Recipe recipe = recipeService.getRecipeById(idString);
    if (recipe == null) {
      return "error/404";
    }
    model.addAttribute("recipe", recipe);
    
    // 検索用カテゴリー取得
    List<Category> categoryList = categoryService.getTagsByCategory();
    model.addAttribute("categoryList", categoryList);
    
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRandomRecipeLimitTwelve();
    model.addAttribute("recommendRecipe", recommendRecipe);
    
    return "recipe/detail";
  }
}
