package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Tag1;


@Mapper
public interface TagMapper {
  
  /**
   * 表示順ごとに12件取得
   * */
  public List<Tag1> getTopTenTags();
  
  /**
   * tag1 使用されてないid取得
   * */
  public List<Integer> getTag1NoUsed();
  
  /**
   * tag1 すべてdisplay=trueにする
   * */
  public void updateAllTag1DisplayTrue();
  
  /**
   * tag1 使用されてないものだけdisplay=falseにする
   * */
  public void updateTag1Display(@Param("tag1NoUsedIds") List<Integer> tag1NoUsedIds);
  
  /**
   * tag2 使用されてないid取得
   * */
  public List<Integer> getTag2NoUsed();
  
  /**
   * tag2 すべてdisplay=trueにする
   * */
  public void updateAllTag2DisplayTrue();
  
  /**
   * tag2 使用されてないものだけdisplay=falseにする
   * */
  public void updateTag2Display(@Param("tag2NoUsedIds") List<Integer> tag2NoUsedIds);
  
}
