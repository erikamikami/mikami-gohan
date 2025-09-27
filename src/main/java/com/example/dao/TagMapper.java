package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Tag;

@Mapper
public interface TagMapper {

  // 表示順ごとに10件取得します
  public List<Tag> getTopTenTags();
  
}
