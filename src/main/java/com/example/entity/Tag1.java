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
public class Tag1 {
  
  private Integer id;
  private String tag1Name;
  private List<Tag2> tag2List;
  private Category category;
  private Integer sortOrder;
  private boolean displayFlg;

}
