package com.example.entity;

import java.util.Arrays;
import java.util.Date;
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
public class Recipe {
  private Integer id;
  private String title;
  private String memo;
  private Integer tag1;
  private String tag1Name;
  private Integer tag2;
  private String tag2Name;
  private Integer tag3;
  private String tag3Name;
  private Integer tag4;
  private String tag4Name;
  private Integer tag5;
  private String tag5Name;
  private Date createdDate;
  private boolean displayflg;
  private boolean recommendflg;
  private List<Material> materials;
  private HowTo howTo;
  private Meta meta;
  
  public List<String> getTagNameList() {
    return Arrays.asList(tag1Name, tag2Name, tag3Name, tag4Name, tag5Name);
  }
}
