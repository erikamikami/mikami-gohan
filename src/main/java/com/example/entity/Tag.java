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
public class Tag {
  
  private Integer id;
  private String tagName;
  private Integer sortOrder;
  private boolean displayFlg;
  private String createDate;

}
