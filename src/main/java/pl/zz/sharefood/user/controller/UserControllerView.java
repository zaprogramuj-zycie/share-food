package pl.zz.sharefood.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.zz.sharefood.user.domain.User;

@Controller
public class UserControllerView {

    @GetMapping("/register")
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "user/registerForm";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/loginForm";
    }


}
