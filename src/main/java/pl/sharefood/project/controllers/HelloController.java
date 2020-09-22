package pl.sharefood.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello-team")
    public String get() {
        return "helloTeam";
    }
}
