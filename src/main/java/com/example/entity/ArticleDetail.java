package com.example.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDetail {
  
  private Article article;
  private Integer id;
  private Integer articleId;
  private Integer articleDetailTypeId;
  private String contents;
  private String caption;
  private Integer recipeId;
  private Recipe recipe;
  private String externalLink;
  private String externalLinkOgpTitle;
  private String externalLinkOgpDomain;
  private String externalLinkOgpImageUrl;
  private Date externalLinkOgpGetDay;
  private boolean externalLinkOgpGetFlg;
  private boolean displayFlg;
  private Integer sortOrder;
  private String createDate;
  private String updateDate;

}
