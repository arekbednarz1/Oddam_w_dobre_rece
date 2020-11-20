package pl.arekbednarz.oddajwdobrerece.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arekbednarz.oddajwdobrerece.entity.Donation;
import pl.arekbednarz.oddajwdobrerece.entity.User;
import pl.arekbednarz.oddajwdobrerece.services.CategoryService;
import pl.arekbednarz.oddajwdobrerece.services.DonationService;
import pl.arekbednarz.oddajwdobrerece.services.InstitutionService;
import pl.arekbednarz.oddajwdobrerece.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/donation")
public class DonationController {

    DonationService donationService;
    InstitutionService institutionService;
    CategoryService categoryService;
    UserService userService;

    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService, UserService userService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping
    String donateForm(Model model) {
        model.addAttribute("donate", new Donation());
        model.addAttribute("categoriesFromServlet", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "views/user/donation";
    }

    @PostMapping
    String donateFormAction(@Valid @ModelAttribute Donation donation, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) {
            return "views/user/donation";
        }
        donation.setUser(userService.findUserByEmail(principal.getName()));
        donationService.save(donation);
        return "views/user/donationConfirm";
    }

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("LoggedUser", user);
        }
    }

}