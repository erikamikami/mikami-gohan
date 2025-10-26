package com.example.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Recipe;

@Mapper
public interface RecipeMapper {

  /**
   * 作成日時が最近順に5件取得
   * @param keywords
   * @return List<Recipe>
   */
  public List<Recipe> getRecipeOrderByCreatedDateLimitFive();

  /**
   * おすすめで作成日時が最近順に6件取得
   * @return List<Recipe>
   */
  public List<Recipe> getRecommendRecipeOrderByCreatedDateLimitSix();
  
  /**
   * ランダムで6件取得
   * @return List<Recipe>
   */
  public List<Recipe> getRandomRecipeLimitSix();

  /**
   * id指定で1件のレシピ情報を取得
   * @param keywords
   * @return Recipe
   */
  public Recipe getRecipeById(Integer id);
  
  /**
   * 作成日順で取得
   * @param keywords
   * @return List<Recipe>
   */
  public List<Recipe> getRecipeLimitThirty();
  
  /**
   * レシピ名か材料名であいまい検索
   * @param keywords
   * @return List<Recipe>
   */
  public List<Recipe> searchByRecipeTitleOrMaterialName(@Param("keywords") List<String> keywords);
  
  /**
   * タグ名で検索
   * @param keywords
   * @return List<Recipe>
   */
  public List<Recipe> searchByTagName(@Param("tags") List<String> tags);
}
