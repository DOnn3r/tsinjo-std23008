package com.example.demo.endpoint.rest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("message", "Welcome to Thymeleaf with Spring Boot!");
    return "home"; // maps to resources/templates/home.html
  }
}
