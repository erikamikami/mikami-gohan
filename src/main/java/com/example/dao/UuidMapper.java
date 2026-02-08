package com.example.dao;


import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UuidMapper {
  
  /**
   * Uuid 取得
   * @return String
   */
  public String getUuid();
  
  /**
   * Uuid 更新
   */
  public void updateUuid(String uuid);

}
