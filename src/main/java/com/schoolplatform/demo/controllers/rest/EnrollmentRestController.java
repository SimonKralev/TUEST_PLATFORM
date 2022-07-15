package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.services.EnrollmentService;
import com.schoolplatform.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class EnrollmentRestController {
    private final EnrollmentService enrollmentService;
    private final UserService userService;

    @PostMapping("/courses/{course_id}")
    public int enrollInCourse(@RequestBody EnrollmentRequest enrollmentRequest, @PathVariable("course_id") String course_id, Principal principal){
        System.out.println("In EnrollmentRestController: enrollInCourse(" + enrollmentRequest + ", " + course_id + ")");
        enrollmentRequest.setStudent(10L);
        enrollmentRequest.setCourse((Long.valueOf(course_id)));
        return enrollmentService.enrollInCourse(enrollmentRequest, principal);
    }

    @GetMapping("/courses/{course_id}/user-enrolled")
    public String isEnrolled(@PathVariable("course_id") Long courseId, Principal principal) {
        System.out.println(enrollmentService.existsByCourseIdAndStudentId(courseId, userService.findUserByEmail(principal.getName()).get().getId()));
        if (enrollmentService.existsByCourseIdAndStudentId(courseId, userService.findUserByEmail(principal.getName()).get().getId())) {
            System.out.println("Returning ENROLLED");
            return "Enrolled";
        }
        else {
            return "Enroll";
        }
    }
}