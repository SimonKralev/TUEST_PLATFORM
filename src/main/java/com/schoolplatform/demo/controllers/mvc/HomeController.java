package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.Enrollment;
import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.models.CourseResponse;
import com.schoolplatform.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {

    UserService userService;
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public ModelAndView upcomingCourses(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        List<Enrollment> enrollments = userService.findUserByEmail(principal.getName()).get().getEnrollments();
        List<CourseResponse> upcomingCourses = new ArrayList<>();

        System.out.println(enrollments);

        for (Enrollment enrollment: enrollments) {
            if (enrollment.getCourse().getDate().after((new Timestamp((new Date()).getTime())))) {
                System.out.println("future enrollment");
                CourseResponse courseResponse = new CourseResponse();
                courseResponse.setId(enrollment.getCourse().getId());
                courseResponse.setUser(enrollment.getCourse().getUser());
                courseResponse.setTitle(enrollment.getCourse().getTitle());
                courseResponse.setSubject(enrollment.getCourse().getSubject());
                courseResponse.setDate(enrollment.getCourse().getDate());
                courseResponse.setPrice(enrollment.getCourse().getPrice());
                courseResponse.setType(enrollment.getCourse().getType().toString());
                courseResponse.setLocation(enrollment.getCourse().getLocation());
                courseResponse.setDisplayableLocation(enrollment.getCourse().getDisplayableLocation());
                courseResponse.setDisplayableSubject(enrollment.getCourse().getDisplayableSubject());
                courseResponse.setVisibility(enrollment.getCourse().getVisibility().toString());
                upcomingCourses.add(courseResponse);
            }
        }
        try {
            modelAndView.setViewName("/home");
            modelAndView.addObject("upcomingCourses", upcomingCourses);
            Optional<User> user = userService.findUserByEmail(principal.getName());
            modelAndView.addObject("user", user.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelAndView;
    }
}
