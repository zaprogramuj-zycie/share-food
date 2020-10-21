package pl.zz.sharefood.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello-team")
    public String get() {
        return "helloTeam";
    }
}
