package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// returns page
@Controller
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public String courseView(){
        return "create-course";
    }
}

