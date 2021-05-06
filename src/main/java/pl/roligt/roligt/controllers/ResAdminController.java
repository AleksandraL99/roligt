package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.roligt.roligt.models.Reservation;
import pl.roligt.roligt.repositories.ReservationsRepo;

import java.util.List;

@Controller
public class ResAdminController {

    private ReservationsRepo reservationsRepo;

    @Autowired
    public ResAdminController(ReservationsRepo reservationsRepo) {
        this.reservationsRepo = reservationsRepo;
    }


    @GetMapping("/resadmin")
    public String getResAdmin(Model model) {
        List<Reservation> resList = reservationsRepo.findAll();
        model.addAttribute("resList", resList);
        return "resadmin";
    }
}
