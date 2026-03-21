package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.CategoryMapper;
import com.example.entity.Category;

@Service
public class CategoryService {
  
  @Autowired
  private CategoryMapper categoryMapper;
  
  /**
   * カテゴリーごとにtag取得する
   * */
  @Cacheable(value = "twentyFourHourCache", key = "'getTagsByCategory'")
  public List<Category> getTagsByCategory(){
    return categoryMapper.getTagsByCategory();
  }
  
}
