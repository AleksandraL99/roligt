package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/login")
    public String getLogin(@RequestParam String email, @RequestParam String password) {
        System.out.printf(email+ ' '+password+"\n");
        System.out.println(loginAndRegistrationService.login(email, password));
        return "loginPage";
    }
    @GetMapping("/loginpage")
    public String getLoginPage(){
        return "loginPage";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "reg";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "loginPage";
    }


    @PostMapping("/add-user")
    public String addUser() {//parametry do usera wszystkie
        //utworzyć obiekt typu User, sprawdzić czy nie istnieje, następnie użyć metody z obiektu UserRep o nazwie save i w parametrze save dać user
        return "loginPage";
    }



}
