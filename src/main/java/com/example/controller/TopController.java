package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Recipe;
import com.example.entity.Tag;
import com.example.service.RecipeService;
import com.example.service.TagService;

@Controller
@RequestMapping("")
public class TopController {
  
  @Autowired
  private RecipeService recipeService;
  
  @Autowired
  private TagService tagService;
  
  @RequestMapping("")
  public String index(Model model) {
    // TOP スライダー用レシピ取得
    List<Recipe> recentlyRecipes = recipeService.getRecipeOrderByCreatedDateLimitFive();
    model.addAttribute("recentlyRecipes", recentlyRecipes);
    
    // 人気のタグ一覧取得
    List<Tag> popularTags = tagService.getTenTags();
    model.addAttribute("popularTags", popularTags);
    
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRecommendRecipeOrderByCreatedDateLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);
    
    return "top";
  }
}
