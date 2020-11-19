package pl.arekbednarz.oddajwdobrerece.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.arekbednarz.oddajwdobrerece.DTO.UserDTO;
import pl.arekbednarz.oddajwdobrerece.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String registerForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "views/user/registration";
    }

    @PostMapping
    String registrationAction(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (!userDTO.getPassword1().equals(userDTO.getPassword2())) model.addAttribute("msg", true);
            return "views/user/registration";
        }
        if (!userDTO.getPassword1().equals(userDTO.getPassword2())) {
            model.addAttribute("msg", true);
            return "views/user/registration";
        }
        userService.saveByDTO(userDTO);
        return "redirect:/login";
    }
}