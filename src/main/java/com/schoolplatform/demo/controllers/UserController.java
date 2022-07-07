package com.schoolplatform.demo.controllers;

import com.schoolplatform.demo.models.RegistrationRequest;
import com.schoolplatform.demo.models.RegistrationResponse;
import com.schoolplatform.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public RegistrationResponse registerUser(@RequestBody RegistrationRequest registrationRequest){
        return userService.createUser(registrationRequest);
    }

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
}

