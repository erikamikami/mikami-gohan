package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.service.UuidService;

@RestController
@RequestMapping("/api")
public class TestApiController {
  
  @Autowired
  UuidService uuidService;
  
  /**
   * UUIDを更新して最新のUUIDを返却します
   */
  @GetMapping(
      value = "/endpointA"
  )
  public ResponseEntity<Map<String, String>> endpointA() {
    return ResponseEntity.ok(Map.of("result", uuidService.updateUuid()));
  }
  
  /**
   * リクエストのUUIDがDBと同じだったらUUIDを更新して200とtokenを返却
   * そうでなかったら400
   */
  @PostMapping(
      value = "/endpointB",
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Map<String, String>> endpointB(@RequestBody Map<String, String> body) {
    String requestUuid = body.get("uuid");
    if(uuidService.comparisonUuid(requestUuid)) {
      uuidService.updateUuid();
      String token = uuidService.updateToken();
      return ResponseEntity.ok(Map.of("result", "OK", "token", token));
    } else {
      return ResponseEntity
          .badRequest()
          .body(Map.of("result", "NG"));
    }
  }
  
  /**
   * リクエストのtokenがDBと同じだったらtokenを更新して200を返却
   * そうでなかったら400
   */
  @GetMapping("/endpointC/{token}")
  public ResponseEntity<Map<String, String>> endpointC(@PathVariable("token") String token) {
    if(uuidService.comparisonToken(token)) {
      uuidService.updateToken();
      return ResponseEntity.ok(Map.of("result", "OK"));
    } else {
      return ResponseEntity
          .badRequest()
          .body(Map.of("result", "NG"));
    }
  }

}
