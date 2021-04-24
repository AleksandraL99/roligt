package pl.roligt.roligt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("/loginpage")
    public String getLogin() {
        return "loginPage";
    }
}
