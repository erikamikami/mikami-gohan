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
public class HowTo {

  private Integer id;
  private String recipeId;
  private String howToNo1;
  private String howToNo2;
  private String howToNo3;
  private String howToNo4;
  private String howToNo5;
  private String howToNo6;
  private String howToNo7;
  private String howToNo8;
  private String howToNo9;
  private String howToNo10;

  public List<String> getHowToList() {
    return Arrays.asList(howToNo1, howToNo2, howToNo3, howToNo4, howToNo5, howToNo6, howToNo7, howToNo8, howToNo9,
        howToNo10);
  }

}
