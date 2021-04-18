package pl.roligt.roligt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class registerController {
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }
}
