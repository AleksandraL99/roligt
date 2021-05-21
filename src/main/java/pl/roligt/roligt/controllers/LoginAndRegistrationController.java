package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.roligt.roligt.models.User;
import pl.roligt.roligt.repositories.UserRepo;
import pl.roligt.roligt.services.LoginAndRegistrationService;


@Controller
public class LoginAndRegistrationController {
    private UserRepo userRepo;
    private LoginAndRegistrationService loginAndRegistrationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginAndRegistrationController(UserRepo userRepo, LoginAndRegistrationService loginAndRegistrationService,
                                          PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.loginAndRegistrationService = loginAndRegistrationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String getLogin(@RequestParam String email, @RequestParam String password, Model model) {
        String encodedPassword = userRepo.findPasswordByEmail(email);
        if (passwordEncoder.matches(password, encodedPassword)) {
            loginAndRegistrationService.addCookie(email);
            return "redirect:/main";
        } else {
            model.addAttribute("loginError", true);
            return "loginPage";
        }
    }

    @GetMapping("/loginpage")
    public String getLoginPage() {
        return "loginPage";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "reg";
    }

    @PostMapping("/add-user")
    public String addUser(@RequestParam String email, @RequestParam String password,
                          @RequestParam String confirmedPassword, @RequestParam String phone, Model model) {
        if (loginAndRegistrationService.checkEmail(email) || !loginAndRegistrationService.validate(email)) {
            model.addAttribute("loginError1", true);
            return "reg";
        } else if (!password.equals(confirmedPassword) || password.length() < 8) {
            model.addAttribute("loginError2", true);
            return "reg";
        } else if (!loginAndRegistrationService.checkPhone(phone)) {
            model.addAttribute("loginError3", true);
            return "reg";
        }
        int phoneNumber = Integer.parseInt(phone);
        password = passwordEncoder.encode(password);;
        User user = new User(email, password, phoneNumber);
        loginAndRegistrationService.saveUser(user);
        return "loginPage";

    }
}
