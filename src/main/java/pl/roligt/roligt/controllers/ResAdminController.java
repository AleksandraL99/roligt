package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.roligt.roligt.models.Reservation;
import pl.roligt.roligt.repositories.ReservationsRepo;
import pl.roligt.roligt.services.ReservationsService;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
public class ResAdminController {

    private ReservationsRepo reservationsRepo;
    private ReservationsService reservationsService;

    @Autowired
    public ResAdminController(ReservationsRepo reservationsRepo, ReservationsService reservationsService) {
        this.reservationsRepo = reservationsRepo;
        this.reservationsService = reservationsService;
    }

    @GetMapping("/resadmin")
    public String getResAdmin(Model model, Principal principal) {
        System.out.println(principal.getName());
        List<Reservation> resList = reservationsRepo.findAll();
        model.addAttribute("resList", resList);
        return "resadmin";
    }

    @PostMapping("/delete/{id}")
    public String deleteReservation(@PathVariable String id, Model model) {
        System.out.println("ID: "+id);
        long num = Long.parseLong(id);
        reservationsService.deleteRecord(num);
        return  "redirect:/resadmin";
    }
}
