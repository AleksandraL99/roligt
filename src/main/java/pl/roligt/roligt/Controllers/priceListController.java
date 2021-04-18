package pl.roligt.roligt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class priceListController {
    @GetMapping("/pricelist")
    public String getReservations() {
        return "priceList";
    }
}
