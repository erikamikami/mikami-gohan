package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.UuidService;

@Controller
@RequestMapping("/test")
public class TestController {
  
  @Autowired
  UuidService uuidService;
  
  /**
   * リクエストA
   * 
   * 更新したUUIDを画面上に返却する
   * 
   * @param model
   * @return
   */
  @RequestMapping("/requestA")
  public String requestA(Model model) {
    String uuid = uuidService.updateUuid();
    model.addAttribute("uuid", uuid);
    return "test/A";
  }
  
  /**
   * リクエストB
   * 
   * リクエストBodyにあるUUIDを取得し、
   * DBと同じだったらUUIDを更新して、更新したtokenを画面に返却
   * そうでなかったら400
   * 
   * @param model
   * @return
   */
  @PostMapping(
      value = "/requestB",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
  )
  public String requestB(@RequestParam("uuid") String uuid, Model model) {
    if(uuidService.comparisonUuid(uuid)) {
      uuidService.updateUuid();
      String token = uuidService.updateToken();
      model.addAttribute("token", token);
      return "test/B";
    } else {
      return "error/400";
    }
  }
  
  /**
   * リクエストB
   * 
   * リクエストBodyにあるtokenを取得し、
   * DBと同じだったらtokenを更新して、成功と画面に返却
   * そうでなかったら400
   * 
   * @param model
   * @return
   */
  @PostMapping(
      value = "/requestC",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
  )
  public String requestC(@RequestParam("token") String token) {
    if(uuidService.comparisonToken(token)) {
      uuidService.updateToken();
      return "test/C";
    } else {
      return "error/400";
    }
  }
}
