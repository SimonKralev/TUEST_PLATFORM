package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.entities.UserType;
import com.schoolplatform.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping("/my-profile")
    public ModelAndView userInfo(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        if (principal == null || principal.getName().isBlank()) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        try {
            User user = userService.findUserByLoginUsername(principal.getName());
            modelAndView.setViewName("/my-profile");
            modelAndView.addObject("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @GetMapping("/profile/{user_id}")
    public ModelAndView otherProfile(@PathVariable("user_id") Long userId, Principal principal) {
        User user = userService.findById(userId);
        ModelAndView modelAndView = new ModelAndView();
        
        if (Objects.equals(principal.getName(), user.getLogin().getUsername())) {
            if (principal == null) {
                modelAndView.setViewName("login");
                return modelAndView;
            }
            try {
                modelAndView.setViewName("/my-profile");
                modelAndView.addObject("user", user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return modelAndView;
        }
        
        try {
            modelAndView.setViewName("/profile");
            modelAndView.addObject("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    
    @GetMapping("/teachers")
    public ModelAndView displayAllTeachers() {
        ModelAndView teachersModelAndView = new ModelAndView();
        try {
            teachersModelAndView.setViewName("/all-teachers");
            teachersModelAndView.addObject("allTeachers", userService.findAllByTypeEquals(UserType.TEACHER));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachersModelAndView;
    }
}
