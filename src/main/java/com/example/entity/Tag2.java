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
public class Tag2 {
  
  private Integer id;
  private Integer tag1Id;
  private String tag2Name;
  private Integer sortOrder;
  private boolean displayFlg;

}
