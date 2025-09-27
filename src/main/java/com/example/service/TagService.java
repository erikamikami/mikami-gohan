package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.TagMapper;
import com.example.entity.Tag;

@Service
public class TagService {
  
  @Autowired
  private TagMapper tagMapper;
  
  /**
   * 一番使用されているタグ10件取得する
   * */
  @Cacheable(value = "oneHourCache", key = "'getTenTags'")
  public List<Tag> getTopTenTags(){
    return tagMapper.getTopTenTags();
  }
}
