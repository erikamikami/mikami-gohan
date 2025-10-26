package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ArticleMapper;
import com.example.entity.Article;
import com.example.entity.ArticleDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ArticleService {

  @Autowired
  private ArticleMapper articleMapper;

  private static final int PAGING_PER_SIZE = 30;

  private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36";

  /**
   * 記事一覧 作成日順で取得
   * 
   * @param keywords
   * @return List<Recipe>
   */
  // @Cacheable(value = "oneHourCache", key = "'getRecipeLimitThirty'")
  public PageInfo<Article> getRecipeLimitThirty(int page) {
    PageHelper.startPage(page, PAGING_PER_SIZE);
    List<Article> resultArticle = articleMapper.getArticleLimitThirty();
    return new PageInfo<>(resultArticle);
  }

  /**
   * 記事id指定で記事1件取得
   * 
   * @param uniqueString
   * @return Article
   */
  // @Cacheable(value = "oneHourCache", key = "'getRecipeById_' + #p0")
  public Article getArticle(String uniqueString) {
    return articleMapper.getArticle(uniqueString);
  }

  /**
   * 記事id指定で記事詳細を取得
   * 
   * @param uniqueString
   * @return List<ArticleDetail>
   */
  @Transactional
  // @Cacheable(value = "oneHourCache", key = "'getRecipeById_' + #p0")
  public List<ArticleDetail> getArticleDetails(String uniqueString) {
    List<ArticleDetail> articleDetails = articleMapper.getArticleDetails(uniqueString);

    // OGPデータ取得
    for (ArticleDetail articleDetail : articleDetails) {
      getOgpData(articleDetail);
    }
    return articleDetails;
  }

  /**
   * OGPデータ取得
   * 
   * @param ArticleDetail
   */
  private void getOgpData(ArticleDetail articleDetail) {
    if (articleDetail.getExternalLink().isBlank() || articleDetail.isExternalLinkOgpGetFlg()) {
      return;
    }
    try {
      Document doc = Jsoup.connect(articleDetail.getExternalLink()).userAgent(USER_AGENT).timeout(5000).get();

      // mataタグOGP取得
      // タイトル
      String metaTitle = doc.select("meta[property^=og:title]").attr("content");
      if (metaTitle.isBlank()) {
        articleDetail.setExternalLinkOgpTitle(doc.title());
      } else {
        articleDetail.setExternalLinkOgpTitle(metaTitle);
      }

      // image画像
      String metaImage = doc.select("meta[property^=og:image]").attr("content");
      articleDetail.setExternalLinkOgpImageUrl(metaImage);

      // ドメイン
      String regex = "^(?:https?://)?([^/]+)";
      Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
      Matcher matcher = pattern.matcher(articleDetail.getExternalLink());

      if (matcher.find()) {
        articleDetail.setExternalLinkOgpDomain(matcher.group(1));
      }

      // OGP 取得日時
      articleDetail.setExternalLinkOgpGetDay(new Date());

    } catch (Exception e) {
      // TODO: handle exception
    }
  }
  
  /** 
   * OGPデータ更新
   * @param List<ArticleDetail>
   * 
   * */
  @Transactional
  public void updateOgpData(List<ArticleDetail> articleDetails) {
    for(ArticleDetail articleDetail : articleDetails) {
      if(!articleDetail.getExternalLink().isBlank() && !articleDetail.isExternalLinkOgpGetFlg()) {
        articleMapper.updateOgpData(articleDetail);
      }
    }
  }

}
