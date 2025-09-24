package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RecipeMapper;
import com.example.entity.Recipe;

@Service
public class RecipeService {

  @Autowired
  private RecipeMapper recipeMapper;
  
  //作成日時が最近順に5件取得します
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive() {
    return recipeMapper.getRecipeOrderByCreatedDateLimitFive();
  }
  
  //おすすめで作成日時が最近順に6件取得します
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix() {
    return recipeMapper.getRecommendRecipeOrderByCreatedDateLimitSix();
  }
  
  // id指定で1件のレシピ情報を取得する
  public Recipe getRecipeById(Integer id) {
    return recipeMapper.getRecipeById(id);
  }

}
