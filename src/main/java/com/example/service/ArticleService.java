package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.ArticleMapper;
import com.example.dao.RecipeMapper;
import com.example.entity.Article;
import com.example.entity.ArticleDetail;
import com.example.entity.Recipe;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleService {
  
  @Autowired
  private ArticleMapper articleMapper;
  
  private static final int PAGING_PER_SIZE = 30;
  
  /**
   * 記事一覧 作成日順で取得
   * @param keywords
   * @return List<Recipe>
   */
  //@Cacheable(value = "oneHourCache", key = "'getRecipeLimitThirty'")
  public PageInfo<Article> getRecipeLimitThirty(int page) {
    PageHelper.startPage(page, PAGING_PER_SIZE);
    List<Article> resultArticle = articleMapper.getArticleLimitThirty();
    return new PageInfo<>(resultArticle);
  }
  
  /**
   * 記事id指定で記事詳細を取得
   * @param keywords
   * @return Recipe
   */
  //@Cacheable(value = "oneHourCache", key = "'getRecipeById_' + #p0")
  public List<ArticleDetail> getArticleDetails(Integer id) {
    return articleMapper.getArticleDetails(id);
  }

}
