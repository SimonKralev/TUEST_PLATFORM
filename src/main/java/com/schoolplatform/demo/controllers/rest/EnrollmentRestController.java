package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.services.CourseService;
import com.schoolplatform.demo.services.EnrollmentService;
import com.schoolplatform.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;

@RequiredArgsConstructor
@RestController
public class EnrollmentRestController {
    private final EnrollmentService enrollmentService;
    private final UserService userService;
    private final CourseService courseService;

    @PostMapping("/courses/{course_id}")
    public int enrollInCourse(@RequestBody EnrollmentRequest enrollmentRequest, @PathVariable("course_id") String course_id, Principal principal){
        System.out.println("In EnrollmentRestController: enrollInCourse(" + enrollmentRequest + ", " + course_id + ")");
        enrollmentRequest.setStudent(10L);
        enrollmentRequest.setCourse((Long.valueOf(course_id)));
        return enrollmentService.enrollInCourse(enrollmentRequest, principal);
    }

    @GetMapping("/courses/{course_id}/user-enrolled")
    public String isEnrolled(@PathVariable("course_id") Long courseId, Principal principal) {
        if (courseService.findCourseById(courseId).getDate().before(new Timestamp((new Date()).getTime()))) {
            return "The course has already ended.";
        }
        if (enrollmentService.existsByCourseIdAndStudentId(courseId, userService.findUserByEmail(principal.getName()).getId())) {
            return "Enrolled";
        }
        else {
            return "Enroll";
        }
    }
}