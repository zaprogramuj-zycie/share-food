package pl.sharefood.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloThymeleafController {

    @GetMapping("/hellothymeleaf")
    public String get(){
        return "helloThymeleaf";
    }

}
