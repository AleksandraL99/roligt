package pl.roligt.roligt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {

    @GetMapping("/main")
    public String getMain(Model model, HttpSession session) {
        if(session.getAttribute("username") != null)
            model.addAttribute("logged", true);
        else
            model.addAttribute("logged", false);
        return "main";
    }

}
