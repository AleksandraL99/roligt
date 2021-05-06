package pl.roligt.roligt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.roligt.roligt.models.Category;
import org.springframework.ui.Model;
import pl.roligt.roligt.repositories.CategoryRepo;

import java.util.List;


@Controller
public class PriceListController {

    private CategoryRepo categoryRepo;

    @Autowired
    public PriceListController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/priceList")
    public String getReservations(Model model) {
        List<Category> categoryList = categoryRepo.findAll();
        model.addAttribute("categoryList", categoryList);
        return "priceList";
    }
}
