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
public class Recipe {
  private Integer id;
  private String title;
  private String memo;
  private Integer tag_1;
  private Integer tag_2;
  private Integer tag_3;
  private Integer tag_4;
  private Integer tag_5;
  private String create_date;
  private boolean display_flg;
  private boolean recommend_flg;

}
