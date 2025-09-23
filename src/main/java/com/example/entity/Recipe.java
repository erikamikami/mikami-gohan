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
  private Integer tag1;
  private Integer tag2;
  private Integer tag3;
  private Integer tag4;
  private Integer tag5;
  private String createdate;
  private boolean displayflg;
  private boolean recommendflg;

}
