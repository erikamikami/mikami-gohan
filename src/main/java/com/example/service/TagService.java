package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.TagMapper;
import com.example.entity.Tag1;

@Service
public class TagService {
  
  @Autowired
  private TagMapper tagMapper;
  
  /**
   * 一番使用されているタグ12件取得する
   * */
  @Cacheable(value = "oneHourCache", key = "'getTenTags'")
  public List<Tag1> getTopTenTags(){
    return tagMapper.getTopTenTags();
  }
  
  /**
   * トリガーメソッド
   * tag display update
   * 
   * 使用されているtagはdisplay=trueにし、
   * 使用されていないtagはdisplay=falseにする
   * */
  @Cacheable(value = "twentyFourHourCache", key = "'updateTagDisplay'")
  public boolean updateTagsDisplay(){
    updateTag1Display();
    updateTag2Display();
    return true;
  }
  
  /**
   * tag1 display update
   * 
   * 使用されているtag1はdisplay=trueにし、
   * 使用されていないtag1はdisplay=falseにする
   * */
  private void updateTag1Display(){
    // tag1 使用されてないid取得
    List<Integer> tag1NoUsedIds = tagMapper.getTag1NoUsed();
    
    // tag1 使用されてないものだけdisplay=falseにする
    tagMapper.updateAllTag1DisplayTrue();
    tagMapper.updateTag1Display(tag1NoUsedIds);
  }
  
  /**
   * tag2 display update
   * 
   * 使用されているtag2はdisplay=trueにし、
   * 使用されていないtag2はdisplay=falseにする
   * */
  private void updateTag2Display(){
    // tag2 使用されてないid取得
    List<Integer> tag2NoUsedIds = tagMapper.getTag2NoUsed();
    
    // tag2 使用されてないものだけdisplay=falseにする
    tagMapper.updateAllTag2DisplayTrue();
    tagMapper.updateTag2Display(tag2NoUsedIds);
  }
  
}
