package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.roligt.roligt.models.Category;
import org.springframework.ui.Model;
import pl.roligt.roligt.repositories.CategoryRepo;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class PriceListController {

    private CategoryRepo categoryRepo;

    @Autowired
    public PriceListController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/priceList")
    public String getReservations(Model model, HttpSession session) {
        List<Category> categoryList = categoryRepo.findAll();

        String[] names = { categoryList.get(1).getName(), categoryList.get(4).getName(), categoryList.get(7).getName(),
                categoryList.get(10).getName() };

        String[] prices = new String[12];

        for(int i=0;i<categoryList.size();i++) {
            prices[i] = categoryList.get(i).getPrice()+"zł";
        }
        if(session.getAttribute("username") != null)
            model.addAttribute("logged", true);
        else
            model.addAttribute("logged", false);
        model.addAttribute("names", names);
        model.addAttribute("prices", prices);
        return "priceList";
    }
}
