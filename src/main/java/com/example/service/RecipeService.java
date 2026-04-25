package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.RecipeMapper;
import com.example.entity.Recipe;
import com.example.entity.Tag1;
import com.example.entity.Tag2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RecipeService {

  @Autowired
  private RecipeMapper recipeMapper;

  private static final int PAGING_PER_SIZE = 30;

  /**
   * 作成日時が最近順に5件取得
   * 
   * @param keywords
   * @return List<Recipe>
   */
  @Cacheable(value = "oneHourCache", key = "'getRecipeOrderByCreatedDateLimitFive'")
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive() {
    return recipeMapper.getRecipeOrderByCreatedDateLimitFive();
  }

  /**
   * おすすめで作成日時が最近順に6件取得
   * 
   * @return List<Recipe>
   */
  @Cacheable(value = "oneHourCache", key = "'getRecommendRecipeOrderByCreatedDateLimitSix'")
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix() {
    return recipeMapper.getRecommendRecipeOrderByCreatedDateLimitSix();
  }

  /**
   * ランダムで6件取得
   * 
   * @return List<Recipe>
   */
  @Cacheable(value = "oneHourCache", key = "'getRandomRecipeLimitSix'")
  public List<Recipe> getRandomRecipeLimitSix() {
    return recipeMapper.getRandomRecipeLimitSix();
  }

  /**
   * ランダムで12件取得
   * 
   * @return List<Recipe>
   */
  @Cacheable(value = "oneMinuteCache", key = "'getRandomRecipeLimitTwelve'")
  public List<Recipe> getRandomRecipeLimitTwelve() {
    return recipeMapper.getRandomRecipeLimitTwelve();
  }

  /**
   * レシピ詳細ページ用 おすすめレシピ 12件
   * 
   * @return List<Recipe>
   */
  public List<Recipe> getReccomendRecipeForRecipeDetail(Recipe recipe) {
    List<Recipe> recommendRecipe = new ArrayList<>();
    int itemCount = 12;

    // まずTag2から探す
    List<String> tag2NameList = new ArrayList<>();
    for (Tag2 tag2 : recipe.getTag2()) {
      tag2NameList.add(tag2.getTag2Name());
    }
    if (tag2NameList.size() >= 1) {
      List<Recipe> recipeSearchByTag2 = recipeMapper.searchByTagName(tag2NameList);

      for (int i = 0; recipeSearchByTag2.size() > i && recommendRecipe.size() < itemCount; i++) {
        if (!recipeSearchByTag2.get(i).getId().equals(recipe.getId())) {
          recommendRecipe.add(recipeSearchByTag2.get(i));
        }

      }
    }

    // Tag2で探した結果、12件に満たさなかったら、残りはTag1から探す
    if (recommendRecipe.size() < itemCount) {
      List<String> tag1NameList = new ArrayList<>();
      for (Tag1 tag1 : recipe.getTag1()) {
        tag1NameList.add(tag1.getTag1Name());
      }
      List<Recipe> recipeSearchByTag1 = recipeMapper.searchByTagName(tag1NameList);

      List<Integer> recipeIdList = new ArrayList<>();
      for (int i = 0; i < recommendRecipe.size(); i++) {
        recipeIdList.add(recommendRecipe.get(i).getId());
      }

      for (int i = 0; recipeSearchByTag1.size() > i && recommendRecipe.size() < itemCount; i++) {
        if (!recipeIdList.contains(recipeSearchByTag1.get(i).getId())
            && !recipeSearchByTag1.get(i).getId().equals(recipe.getId())) {
          recommendRecipe.add(recipeSearchByTag1.get(i));
        }
      }
    }
    return recommendRecipe;
  }

  /**
   * id指定で1件のレシピ情報を取得
   * 
   * @param keywords
   * @return Recipe
   */
  @Cacheable(value = "oneHourCache", key = "'getRecipeById_' + #p0")
  public Recipe getRecipeById(String idString) {
    return recipeMapper.getRecipeById(idString);
  }

  /**
   * 作成日順で取得
   * 
   * @param keywords
   * @return List<Recipe>
   */
  public PageInfo<Recipe> getRecipeLimitThirty(int page) {
    PageHelper.startPage(page, PAGING_PER_SIZE);
    List<Recipe> resultRecipe = recipeMapper.getRecipeLimitThirty();
    return new PageInfo<>(resultRecipe);
  }

  /**
   * レシピ名か材料名であいまい検索
   * 
   * @param keywords
   * @return List<Recipe>
   */
  public PageInfo<Recipe> searchByRecipeTitleOrMaterialName(String keyword, int page) {
    List<String> searchKeyword = new ArrayList<>();

    PageHelper.startPage(page, PAGING_PER_SIZE);

    // 全角半角スペースで分割し、Mapに格納
    String[] words = keyword.split("[\\s\u3000]+");
    for (int i = 0; i < words.length; i++) {
      searchKeyword.add(words[i]);
    }

    List<Recipe> resultRecipe = recipeMapper.searchByRecipeTitleOrMaterialName(searchKeyword);

    return new PageInfo<>(resultRecipe);
  }

  /**
   * タグ名で検索
   * 
   * @param keywords
   * @return List<Recipe>
   */
  public PageInfo<Recipe> searchByTagName(List<String> tags, int page) {
    PageHelper.startPage(page, PAGING_PER_SIZE);
    List<Recipe> resultRecipe = recipeMapper.searchByTagName(tags);
    return new PageInfo<>(resultRecipe);
  }

}
