package pl.roligt.roligt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class reservationsController {

    @GetMapping("/reservations")
    public String getReservations() {
        return "reservations";
    }


}
