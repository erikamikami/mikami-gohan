package com.example.service;

import java.security.SecureRandom;
import java.util.Base64;
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
   * token 取得
   * */
  private String getToken(){
    return uuidMapper.getToken();
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
 
 /**
  * uuid 比較
  * */
 public boolean comparisonUuid(String uuid){
   String originalUuid = getUuid();
   return originalUuid.equals(uuid);
 }
 
 /**
  * token 更新,返却
  * */
 public String updateToken(){
   byte[] bytes = new byte[24];
   new SecureRandom().nextBytes(bytes);
   String token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
   
   uuidMapper.updateToken(token);
   return token;
 }
 
 /**
  * token 比較
  * */
 public boolean comparisonToken(String token){
   String originalToken = getToken();
   return originalToken.equals(token);
 }

}
