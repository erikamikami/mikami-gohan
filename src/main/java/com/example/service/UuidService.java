package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UuidMapper;

@Service
public class UuidService {
  
  @Autowired
  private UuidMapper uuidMapper;
  
  /**
   * uuid 取得
   * */
  private String getUuid(){
    return uuidMapper.getUuid();
  }
  
  /**
  * uuid 更新,返却
  * */
 public String updateUuid(){
   UUID uuid = UUID.randomUUID();
   String uuidStr = uuid.toString();
   uuidMapper.updateUuid(uuidStr);
   return uuidStr;
 }
 
 public boolean comparisonUuid(String uuid){
   String originalUuid = getUuid();
   return originalUuid.equals(uuid);
 }

}
