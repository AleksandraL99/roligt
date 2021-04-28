package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.roligt.roligt.repositories.UserRepo;
import pl.roligt.roligt.services.LoginAndRegistrationService;

@Controller
public class LoginAndRegistrationController {
    private UserRepo userRepo;
    private LoginAndRegistrationService loginAndRegistrationService;

    @Autowired
    public LoginAndRegistrationController(UserRepo userRepo, LoginAndRegistrationService loginAndRegistrationService) {
        this.userRepo = userRepo;
        this.loginAndRegistrationService = loginAndRegistrationService;
    }

    @PostMapping("/loginpage")
    public String getLogin(@RequestParam String email, @RequestParam String password) {
        loginAndRegistrationService.login(email, password);
        return "loginPage";
    }

    @PostMapping("/register")
    public String getRegister() {
        return "register";
    }
}
