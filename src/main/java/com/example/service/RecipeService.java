package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.RecipeMapper;
import com.example.entity.Recipe;

@Service
public class RecipeService {

  @Autowired
  private RecipeMapper recipeMapper;

  // 作成日時が最近順に5件取得します
  @Cacheable(value = "oneHourCache", key = "'getRecipeOrderByCreatedDateLimitFive'")
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive() {
    return recipeMapper.getRecipeOrderByCreatedDateLimitFive();
  }

  // おすすめで作成日時が最近順に6件取得します
  @Cacheable(value = "oneHourCache", key = "'getRecommendRecipeOrderByCreatedDateLimitSix'")
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix() {
    return recipeMapper.getRecommendRecipeOrderByCreatedDateLimitSix();
  }

  // id指定で1件のレシピ情報を取得する
  @Cacheable(value = "oneHourCache", key = "'getRecipeById_' + #p0")
  public Recipe getRecipeById(Integer id) {
    return recipeMapper.getRecipeById(id);
  }

  // 作成日順で 30件取得する
  @Cacheable(value = "oneHourCache", key = "'getRecipeLimitThirty'")
  public List<Recipe> getRecipeLimitThirty() {
    return recipeMapper.getRecipeLimitThirty();
  }

  // レシピ名か材料名であいまい検索 30件取得する
  public List<Recipe> searchByRecipeTitleOrMaterialName(String keyword){
    List<String> searchKeyword = new ArrayList<>();
    
    // 全角半角スペースで分割し、Mapに格納
    String[] words = keyword.split("[\\s\u3000]+");
    for(int i = 0; i < words.length; i++) {
      searchKeyword.add(words[i]);
    }
    
    return recipeMapper.searchByRecipeTitleOrMaterialName(searchKeyword);
  }
  
  // タグ名で検索する。30件取得する。
  public List<Recipe> searchByTagName(List<String> tags){
    return recipeMapper.searchByTagName(tags);
  }

}
