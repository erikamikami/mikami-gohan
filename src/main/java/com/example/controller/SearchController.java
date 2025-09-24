package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Recipe;
import com.example.service.RecipeService;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  private RecipeService recipeService;

  @RequestMapping("")
  public String search(@RequestParam(value = "keyword", required = false) String keyword,
      @RequestParam(value = "tag", required = false) List<String> tag,
      Model model) {
    // おすすめレシピの取得
    List<Recipe> recommendRecipe = recipeService.getRecommendRecipeOrderByCreatedDateLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);

    // 検索窓への入力があった場合
    if (keyword != null && keyword != "") {
      List<Recipe> searchRecipe = recipeService.searchByRecipeTitleOrMaterialName(keyword);
      model.addAttribute("searchRecipe", searchRecipe);
      return "/search/index";
    // タグでの検索だった場合
    } else if(tag != null) {
      List<Recipe> searchRecipe = recipeService.searchByTagName(tag);
      model.addAttribute("searchRecipe", searchRecipe);
      return "/search/index";
    // 検索条件なしの場合
    } else {
      List<Recipe> searchRecipe = recipeService.getRecipeLimitThirty();
      model.addAttribute("searchRecipe", searchRecipe);
      return "/search/index";
    }

  }
}
