package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    UserRepository userRepository;

    // TO DO: find out why user repository is not working

    @GetMapping("/my-profile")
    public ModelAndView displayCourse(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            System.out.println(userRepository.findUserByLoginUsername(principal.getName()));
            Optional<User> user = userRepository.findUserByLoginUsername(principal.getName());
            modelAndView.setViewName("/my-profile");
            modelAndView.addObject("user", user.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
