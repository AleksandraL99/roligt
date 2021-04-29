package pl.roligt.roligt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PriceListController {
    @GetMapping("/priceList")
    public String getReservations() {
        return "priceList";
    }
}
