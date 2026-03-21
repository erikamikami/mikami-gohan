package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Category;

@Mapper
public interface CategoryMapper {
  
  /**
   * カテゴリーごとにtag取得する
   * */
  public List<Category> getTagsByCategory();
  
}
