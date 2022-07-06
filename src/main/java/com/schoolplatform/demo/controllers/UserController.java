package com.schoolplatform.demo.controllers;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class UserController {

    @Autowired
    private UserService service;

/*
    // login
    @GetMapping("/")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/HomePage")
    public String registerUser(@ModelAttribute("user") User user){
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        User userdata=service.registerUser(user.getEmail(), user.getPassword());
        if (user.getPassword().equals(userdata.getPassword())){
            return "home"
        } else{
            return "error"
        }
    }
*/

    @GetMapping
    public String register(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user){
        System.out.println(user);
        service.registerUser(user);
        return "home";
    }
}

