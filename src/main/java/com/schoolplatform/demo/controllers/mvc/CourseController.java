package com.schoolplatform.demo.controllers.mvc;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CourseController {
    // mvc controllers are used to simply display content
    private final CourseService courseService;

    @GetMapping("/courses/create")
    public String courseView(){
        return "create-course";
    }
    @GetMapping("/courses/all")
    public ModelAndView displayAllCourses() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Iterable<Course> allCourses = courseService.findAllByOrderByDateAsc();
            modelAndView.setViewName("all-courses");
            modelAndView.addObject("allCourses", allCourses);

        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @GetMapping("/courses/{course_id}")
    public ModelAndView displayCourse(@PathVariable("course_id") String course_id) {
        ModelAndView courseModelAndView = new ModelAndView();
        try {
            Course course = courseService.findCourseById(Long.valueOf(course_id));
            courseModelAndView.setViewName("/course");
            courseModelAndView.addObject("course", course);
        } catch (Exception e) {
            e.printStackTrace();
            courseModelAndView.setViewName("error");
        }
        return courseModelAndView;
    }
}