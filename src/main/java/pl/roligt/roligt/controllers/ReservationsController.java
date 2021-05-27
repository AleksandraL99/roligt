package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.roligt.roligt.models.Category;
import pl.roligt.roligt.models.Reservation;
import pl.roligt.roligt.models.User;
import pl.roligt.roligt.repositories.ReservationsRepo;
import pl.roligt.roligt.services.ReservationsService;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
public class ReservationsController {
    private List<Reservation> reservations;
    private ReservationsService reservationsService;
    private ReservationsRepo reservationsRepo;

    @Autowired
    public ReservationsController(ReservationsRepo reservationsRepo, ReservationsService reservationsService) {
        this.reservationsRepo = reservationsRepo;
        this.reservationsService = reservationsService;
    }


    public ReservationsController() {
        List<Reservation> resList = reservationsRepo.findAll();
    }

    @GetMapping("/reservations")
    public String getReservations(Model model, HttpSession session) {
        if (session.getAttribute("username") != null)
            model.addAttribute("logged", true);
        else
            model.addAttribute("logged", false);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("reservations", reservations);
        model.addAttribute("newReservation", new Reservation());
        return "reservations";
    }

    @PostMapping("/add")
    public String addReservations(@RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year,
                                  @RequestParam Integer hour, @RequestParam Integer minute, @RequestParam String place,
                                  @RequestParam String children, @RequestParam String partyType, Model model,
                                  HttpSession session) {
        Date date = reservationsService.convertDate(day, month, year);
        Time time = reservationsService.convertTime(hour, minute);

        if (reservationsService.checkDate(date)) {
            model.addAttribute("dateError", true);
        } else {
            Category category = reservationsService.getCategory(partyType, children);
            model.addAttribute("correct", true);
            User user = reservationsService.getUser((String)session.getAttribute("username"));
            Reservation reservation = new Reservation(user, date, time, place, category);
            reservationsService.saveReservation(reservation);
        }
        model.addAttribute("logged", true);
        return "reservations";
    }

    @GetMapping("/resnotlog")
    public String getResNotLog(HttpSession session) {
        String mail = (String) session.getAttribute("username");
        String role = reservationsService.getRole(mail);
        if (role.equals("ADMIN"))
            return "redirect:/resadmin";
        else if (role.equals("USER"))
            return "redirect:/reservations";
        return "resnotlog";
    }
}
