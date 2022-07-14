package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.CourseCreationRequest;
import com.schoolplatform.demo.models.CourseCreationResponse;
import com.schoolplatform.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

// methods
@RequiredArgsConstructor
@RestController
public class CourseRestController {

    private final CourseService courseService;

    @RequestMapping("/courses/create") // go to the created course (later)
    public CourseCreationResponse createCourse(@RequestBody CourseCreationRequest courseCreationRequest, Principal principal){
        return courseService.createCourse(courseCreationRequest, principal);
    }
}
