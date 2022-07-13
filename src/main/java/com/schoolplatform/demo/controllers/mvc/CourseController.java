package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.Review;
import com.schoolplatform.demo.repository.CourseRepository;
import com.schoolplatform.demo.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

// returns page
@Controller
@RequiredArgsConstructor
public class CourseController {
    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/courses/create")
    public String courseView(){
        return "create-course";
    }

    @GetMapping("/courses/all")
    public ModelAndView displayAllCourses() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Iterable<Course> allCourses = courseRepository.findAll();
            modelAndView.setViewName("all-courses");
            modelAndView.addObject("allCourses", allCourses);
        } catch (Exception e) {
            e.printStackTrace();
            //modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    //@PostMapping(value = ("/course/{course_id}"))
    @GetMapping("/courses/{course_id}")
    public ModelAndView displayCourse(@PathVariable("course_id") String course_id) {
        ModelAndView courseModelAndView = new ModelAndView();
        try {
            Course course = courseRepository.findCourseById(Long.valueOf(course_id));
            courseModelAndView.setViewName("/course");
            courseModelAndView.addObject("course", course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseModelAndView;
    }

    /*
    WILL work later
    @GetMapping("home")
    public ModelAndView upcomingCourses() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Course upcomingCourses = courseService.findEnrolledCourses();
            modelAndView.setViewName("/courses/(path=${course.getId()})");
            modelAndView.addObject("course", course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    */
}

