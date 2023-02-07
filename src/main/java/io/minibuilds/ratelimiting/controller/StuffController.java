package io.minibuilds.ratelimiting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StuffController {

  @PostMapping("/login")
  public Map<String, String> login() {
    return Map.of("success", "true");
  }

  @GetMapping("/stuff")
  public List<String> getStuff() {
    return List.of("Banana", "Baked Beans");
  }
}
