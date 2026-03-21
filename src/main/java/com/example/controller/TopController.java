package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Category;
import com.example.entity.Recipe;
import com.example.entity.Tag1;
import com.example.service.CategoryService;
import com.example.service.RecipeService;
import com.example.service.TagService;

@Controller
@RequestMapping("")
public class TopController {
  
  @Autowired
  private RecipeService recipeService;
  
  @Autowired
  private TagService tagService;
  
  @Autowired
  private CategoryService categoryService;
  
  @RequestMapping("")
  public String index(Model model) {
    // TOP スライダー用レシピ取得
    List<Recipe> recentlyRecipes = recipeService.getRecipeOrderByCreatedDateLimitFive();
    model.addAttribute("recentlyRecipes", recentlyRecipes);
    
    // 使用されているtagはdisplay=trueにし、使用されていないtagはdisplay=falseにする
    tagService.updateTagsDisplay();
    
    // 検索用カテゴリー取得
    List<Category> categoryList = categoryService.getTagsByCategory();
    model.addAttribute("categoryList", categoryList);
    
    // 人気のタグ一覧取得
    List<Tag1> popularTags = tagService.getTopTenTags();
    model.addAttribute("popularTags", popularTags);
    
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRandomRecipeLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);
    
    return "top";
  }
}
