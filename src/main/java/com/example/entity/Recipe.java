package com.example.entity;

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
  private String idString;
  private String title;
  private String memo;
  private Date createdDate;
  private boolean displayflg;
  private boolean recommendflg;
  private List<Material> materials;
  private List<Tag1> tag1;
  private List<Tag2> tag2;
  private HowTo howTo;
  private Meta meta;
  
}
