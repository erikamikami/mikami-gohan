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
   * token 取得
   * @return String
   */
  public String getToken();
  
  /**
   * Uuid token 更新
   */
  public void updateUuid(String uuid);
  
  /**
   * Uuid token 更新
   */
  public void updateToken(String token);

}
