package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.CourseCreationRequest;
import com.schoolplatform.demo.models.CourseCreationResponse;
import com.schoolplatform.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class CourseRestController {
    // rest controllers are used to for methods
    private final CourseService courseService;

    @RequestMapping("/courses/create") // go to the created course (later)
    public CourseCreationResponse createCourse(@RequestBody CourseCreationRequest courseCreationRequest, Principal principal) {
        return courseService.createCourse(courseCreationRequest, principal);
    }

    @GetMapping("/courses/{course_id}/course-rating")
    public Double courseRating(@PathVariable("course_id") Long courseId) {
        Double rating = courseService.findCourseById(courseId).averageRating();
        if (rating.isNaN()) {
            return Double.valueOf(0);
        }
        return rating;
    }
}
