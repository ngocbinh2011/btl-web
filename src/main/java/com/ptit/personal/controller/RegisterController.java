package com.ptit.personal.controller;


import com.ptit.personal.entity.User;
import com.ptit.personal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private IUserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "sign-up";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user) {
        try{
            if (userService.addUser(user) != null) {
                return "redirect:/registration?message=success";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/registration?error";
    }
}

