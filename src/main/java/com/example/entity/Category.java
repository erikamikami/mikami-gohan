package com.example.entity;

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
public class Category {
  
  private Integer id;
  private String categoryName;
  private List<Tag1> tag1List;
  private Integer sortOrder;
  private boolean displayFlg;

}
