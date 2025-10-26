package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Article;
import com.example.entity.ArticleDetail;
import com.example.entity.Recipe;
import com.example.service.ArticleService;
import com.example.service.RecipeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  private RecipeService recipeService;

  @Autowired
  private ArticleService articleService;

  @RequestMapping("")
  public String index(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRandomRecipeLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);

    // 記事一覧取得
    PageInfo<Article> articles = articleService.getRecipeLimitThirty(page);
    model.addAttribute("articles", articles);
    return "article/index";
  }

  @RequestMapping("{uniqueString}")
  public String detail(@PathVariable("uniqueString") String uniqueString, Model model) {
    // おすすめのレシピ取得
    List<Recipe> recommendRecipe = recipeService.getRandomRecipeLimitSix();
    model.addAttribute("recommendRecipe", recommendRecipe);

    // 記事詳細 取得
    List<ArticleDetail> articleDetails = articleService.getArticleDetails(uniqueString);
    model.addAttribute("articleDetails", articleDetails);
    
    // OGP更新
    articleService.updateOgpData(articleDetails);
    
    return "article/detail";
  }
  
}
