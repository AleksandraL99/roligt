package pl.roligt.roligt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.roligt.roligt.databaseFiles.Reservations;

@Controller
public class resAdminController {
    @GetMapping("/resadmin")
    public String getResAdmin(Model model) {
        //Reservations reservation = new Reservations(1,1,2021/11/02, "13:30", "Kraków", 9);
        model.addAttribute("userEmail","anowak@gmail.com");
        model.addAttribute("userPhone","987354213");
        model.addAttribute("eventDate","12-06-2021");
        model.addAttribute("eventHour","13:30");
        model.addAttribute("eventPlace","Kraków, Kolorowa,48");
        model.addAttribute("numberOfChildren","12");
        return "resadmin";
    }
}
