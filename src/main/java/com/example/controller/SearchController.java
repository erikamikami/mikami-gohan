package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Recipe;
import com.example.entity.Tag;
import com.example.service.RecipeService;
import com.example.service.TagService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  private RecipeService recipeService;
  
  @Autowired
  private TagService tagService;

  @RequestMapping("")
  public String search(
      @RequestParam(value = "keyword", required = false) String keyword,
      @RequestParam(value = "tag", required = false) List<String> tag,
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      Model model) {
    // おすすめレシピの取得
    List<Recipe> recommendRecipe = recipeService.getRandomRecipeLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);
    
    // おすすめタグの取得
    List<Tag> recommendTags = tagService.getTopTenTags();
    model.addAttribute("recommendTags", recommendTags);
    
    // 検索窓への入力があった場合
    if (keyword != null && keyword != "") {
      PageInfo<Recipe> searchRecipe = recipeService.searchByRecipeTitleOrMaterialName(keyword, page);
      model.addAttribute("searchRecipe", searchRecipe);
      model.addAttribute("keyword", keyword);
      return "search/index";
    // タグでの検索だった場合
    } else if(tag != null) {
      PageInfo<Recipe> searchRecipe = recipeService.searchByTagName(tag, page);
      model.addAttribute("searchRecipe", searchRecipe);
      String searchTags = tag.stream().collect(Collectors.joining(", "));
      model.addAttribute("searchTags", searchTags);
      return "search/index";
    // 検索条件なしの場合
    } else {
      PageInfo<Recipe> searchRecipe = recipeService.getRecipeLimitThirty(page);
      model.addAttribute("searchRecipe", searchRecipe);
      return "search/index";
    }

  }
}
