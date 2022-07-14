package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {

    UserRepository userRepository;
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public ModelAndView home(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Optional<User> user = userRepository.findUserByLoginUsername(principal.getName());
            modelAndView.setViewName("/home");
            modelAndView.addObject("user", user.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
