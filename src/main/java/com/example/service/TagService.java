package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TagMapper;
import com.example.entity.Tag;

@Service
public class TagService {
  
  @Autowired
  private TagMapper tagMapper;
  
  /**
   * 表示順ごとに10件取得します
   * */
  public List<Tag> getTenTags(){
    return tagMapper.getTenTags();
  }
}
