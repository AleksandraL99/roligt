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
        //wyrzucić z zmiennej zmienn.email np
        List<Reservation> resList = reservationsRepo.findAll();
        //liste wrzucam gotową, pętla w html
        /*model.addAttribute("userEmail","anowak@gmail.com");
        model.addAttribute("userPhone","987354213");
        model.addAttribute("eventDate","12-06-2021");
        model.addAttribute("eventHour","13:30");
        model.addAttribute("eventPlace","Kraków, Kolorowa,48");
        model.addAttribute("numberOfChildren","12");
        for (Reservation i: resList) {
            System.out.println(i+"\n");
        }*/
        model.addAttribute("resList", resList);
        return "resadmin";
    }
}
