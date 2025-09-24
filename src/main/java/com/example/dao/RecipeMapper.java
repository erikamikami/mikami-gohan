package com.example.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Recipe;

@Mapper
public interface RecipeMapper {

  // 作成日時が最近順に5件取得します
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive();

  // おすすめで作成日時が最近順に6件取得します
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix();

  // id指定で1件のレシピ情報を取得する
  public Recipe getRecipeById(Integer id);
  
  // 作成日順で 30件取得する
  public List<Recipe> getRecipeLimitThirty();
  
  // レシピ名か材料名であいまい検索 30件取得する
  public List<Recipe> searchByRecipeTitleOrMaterialName(@Param("keywords") List<String> keywords);
}
