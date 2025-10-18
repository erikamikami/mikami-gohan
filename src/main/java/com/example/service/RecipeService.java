package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.RecipeMapper;
import com.example.entity.Recipe;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RecipeService {

  @Autowired
  private RecipeMapper recipeMapper;
  
  private static final int PAGING_PER_SIZE = 30;

  /**
   * 作成日時が最近順に5件取得
   * @param keywords
   * @return List<Recipe>
   */
  @Cacheable(value = "oneHourCache", key = "'getRecipeOrderByCreatedDateLimitFive'")
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive() {
    return recipeMapper.getRecipeOrderByCreatedDateLimitFive();
  }

  /**
   * おすすめで作成日時が最近順に6件取得
   * @param keywords
   * @return List<Recipe>
   */
  @Cacheable(value = "oneHourCache", key = "'getRecommendRecipeOrderByCreatedDateLimitSix'")
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix() {
    return recipeMapper.getRecommendRecipeOrderByCreatedDateLimitSix();
  }

  /**
   * id指定で1件のレシピ情報を取得
   * @param keywords
   * @return Recipe
   */
  @Cacheable(value = "oneHourCache", key = "'getRecipeById_' + #p0")
  public Recipe getRecipeById(Integer id) {
    return recipeMapper.getRecipeById(id);
  }

  /**
   * 作成日順で取得
   * @param keywords
   * @return List<Recipe>
   */
  @Cacheable(value = "oneHourCache", key = "'getRecipeLimitThirty'")
  public PageInfo<Recipe> getRecipeLimitThirty(int page) {
    PageHelper.startPage(page, PAGING_PER_SIZE);
    List<Recipe> resultRecipe = recipeMapper.getRecipeLimitThirty();
    return new PageInfo<>(resultRecipe);
  }

  /**
   * レシピ名か材料名であいまい検索
   * @param keywords
   * @return List<Recipe>
   */
  public PageInfo<Recipe> searchByRecipeTitleOrMaterialName(String keyword, int page){
    List<String> searchKeyword = new ArrayList<>();

    PageHelper.startPage(page, PAGING_PER_SIZE);
    
    // 全角半角スペースで分割し、Mapに格納
    String[] words = keyword.split("[\\s\u3000]+");
    for(int i = 0; i < words.length; i++) {
      searchKeyword.add(words[i]);
    }
    
    List<Recipe> resultRecipe = recipeMapper.searchByRecipeTitleOrMaterialName(searchKeyword);
    
    return new PageInfo<>(resultRecipe);
  }
  
  /**
   * タグ名で検索
   * @param keywords
   * @return List<Recipe>
   */
  public PageInfo<Recipe> searchByTagName(List<String> tags, int page){
    PageHelper.startPage(page, PAGING_PER_SIZE);
    List<Recipe> resultRecipe = recipeMapper.searchByTagName(tags);
    return new PageInfo<>(resultRecipe);
  }

}
