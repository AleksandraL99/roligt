package pl.roligt.roligt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    @GetMapping("/priceList")
    public String getPriceList() {
        return "priceList";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/reservations")
    public String getReservations() {
        return "reservations";
    }

    @GetMapping("/resadmin")
    public String getResadmin() {
        return "resadmin";
    }

    @GetMapping("/resnotlog")
    public String getResnotlog() {
        return "resnotlog";
    }
}
