package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.roligt.roligt.models.Reservation;
import pl.roligt.roligt.repositories.ReservationsRepo;

import java.util.List;

@Controller
public class ReservationsController {
    private List<Reservation> reservations;

    private ReservationsRepo reservationsRepo;
    @Autowired
    public ReservationsController(ReservationsRepo reservationsRepo) {
        this.reservationsRepo = reservationsRepo;
    }


    public ReservationsController() {
        List<Reservation> resList = reservationsRepo.findAll();
    }

    @GetMapping("/reservations")
    public String getReservations(Model model) {
        model.addAttribute("reservations", reservations);
        model.addAttribute("newReservation", new Reservation());
        return "reservations";
    }

    @PostMapping("/add")
    public  String addReservation(@RequestBody Reservation reservation) {
        System.out.println(reservation);
        return "redirect:/reservations";
    }

}
