package com.example.entity;

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
  
  private Integer id;
  private Integer articleId;
  private Integer atricleDetailTypeId;
  private String contents;
  private String caption;
  private Integer recipeId;
  private Recipe recipe;
  private String externalLink;
  private String externalLinkOgpTitle;
  private String externalLinkOgpDomain;
  private String externalLinkOgpImageUrl;
  private String externalLinkOgpGetDay;
  private boolean displayFlg;
  private Integer sortOrder;
  private String createDate;
  private String updateDate;

}
