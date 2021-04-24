package pl.roligt.roligt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class priceListController {
    @GetMapping("/priceList")
    public String getReservations() {
        return "priceList";
    }
}
