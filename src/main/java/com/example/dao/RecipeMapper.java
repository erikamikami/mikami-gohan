package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Recipe;

@Mapper
public interface RecipeMapper {

  // 作成日時が最近順に5件取得します
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive();

  // おすすめで作成日時が最近順に6件取得します
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix();
}
