package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    UserRepository userRepository;

    // TO DO: find out why user repository is not working
    @GetMapping("/my-profile")
    public ModelAndView displayCourse() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            //User user = userRepository.findUserByEmail("irina04@gmail.com");
            User user = new User("Ceca", "Mecata", "az@abv.bg", "lorem ipsum");
            modelAndView.setViewName("/my-profile");
            modelAndView.addObject("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
