package pl.arekbednarz.oddajwdobrerece.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arekbednarz.oddajwdobrerece.DTO.PasswordDTO;
import pl.arekbednarz.oddajwdobrerece.entity.Donation;
import pl.arekbednarz.oddajwdobrerece.entity.Institution;
import pl.arekbednarz.oddajwdobrerece.entity.User;
import pl.arekbednarz.oddajwdobrerece.services.DonationService;
import pl.arekbednarz.oddajwdobrerece.services.InstitutionService;
import pl.arekbednarz.oddajwdobrerece.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DetailsController {

    UserService userService;
    InstitutionService institutionService;
    DonationService donationService;
    BCryptPasswordEncoder passwordEncoder;

    public DetailsController(UserService userService, InstitutionService institutionService, DonationService donationService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    String showHome(Model model, Principal principal) {
        System.out.println();
        return "views/user/index";
    }

    @ModelAttribute
    void addNewInstitution(Model model) {
        List<Institution> institutions = institutionService.findAll();
        List<List<Institution>> pairs = new ArrayList<>();
        for (int i = 0; i < institutions.size(); i += 2) {
            List<Institution> pair = new ArrayList<>();
            pair.add(institutions.get(i));
            if ((i + 1) < institutions.size()) pair.add(institutions.get(i + 1));
            pairs.add(pair);
        }
        model.addAttribute("pairsInstitution", pairs);
    }

    @ModelAttribute
    void addDonations(Model model) {
        List<Donation> donations = donationService.findAll();
        int generalQuantity = donations.stream().mapToInt(Donation::getQuantity).sum();
        model.addAttribute("quantityOfDonation", donations.size());
        model.addAttribute("quantityOfPacks", generalQuantity);
    }

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("LoggedUser", user);
        }
    }

    @GetMapping("/details")
    String getLoggedUserDetails() {
        return "views/user/details";
    }

    @GetMapping("/details/edit")
    String editLoggedUser(Model model, Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "views/user/edit";
    }

    @PostMapping("/details/edit")
    String EditLoggedUserAction(@Valid User user, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "views/user/edit";
        }
        User userLogged = userService.findUserByEmail(principal.getName());
        userLogged.setName(user.getName());
        userLogged.setSurname(user.getSurname());
        userLogged.setEmail(user.getEmail());
        userService.save(userLogged);
        return "views/user/edit";
    }


    @GetMapping("/details/editpass")
    String editLoggedUserPass(Model model) {
        model.addAttribute("passwordDto", new PasswordDTO());
        return "views/user/editpass";
    }

    @PostMapping("/details/editpass")
    String editLoggedUserPassAction(@Valid PasswordDTO passwordDTO, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "views/user/editpass";
        }
        if (!passwordDTO.getPassword().equals(passwordDTO.getPasswordRepeat())) {
            model.addAttribute("msg", true);
            return "views/user/editpass";
        }
        User user = userService.findUserByEmail(principal.getName());
        user.setPassword(passwordEncoder.encode(passwordDTO.getPassword()));
        userService.save(user);
        return "redirect:/details";
    }
}