package com.gmail.kutilandrej.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

  @GetMapping("/humans")
  public String getAllHumans() {
    return "all_humans";
  }

  @GetMapping("/hrs/info")
  public String getInfoOnlyForHRs() {
    return "hr";
  }

  @GetMapping("/managers/info")
  public String getInfoOnlyForManagers() {
    return "manager";
  }
}
