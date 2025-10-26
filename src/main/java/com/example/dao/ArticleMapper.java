package com.example.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Article;
import com.example.entity.ArticleDetail;

@Mapper
public interface ArticleMapper {
  
  /**
   * 作成日順で取得
   * @param 
   * @return List<Article>
   */
  public List<Article> getArticleLimitThirty();
  
  /**
   * 記事1件取得
   * @param 
   * @return Article
   */
  public Article getArticle(String uniqueString);
  
  /**
   * 記事詳細 取得
   * @param 
   * @return Article
   */
  public List<ArticleDetail> getArticleDetails(String uniqueString);
  
  /**
   * OGP設定　更新
   * @param ArticleDetail
   */
  public int updateOgpData(ArticleDetail articleDetail);

}
