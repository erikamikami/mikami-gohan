package com.example.entity;

import java.util.Arrays;
import java.util.List;
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
public class Article {
  
  private Integer id;
  private String uniqueString;
  private String title;
  private String introduction;
  private Integer sortOrder;
  private boolean displayFlg;
  private String createDate;
  private List<ArticleDetail> articleDetails;

}
