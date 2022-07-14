package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;
import com.schoolplatform.demo.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class EnrollmentRestController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/courses/{course_id}")
    public EnrollmentResponse enrollInCourse(@RequestBody EnrollmentRequest enrollmentRequest, @PathVariable("course_id") String course_id){
        System.out.println("In EnrollmentRestController: enrollInCourse(" + enrollmentRequest + ", " + course_id + ")");
        enrollmentRequest.setStudent(10L);
        enrollmentRequest.setCourse(Long.parseLong(course_id));
        return enrollmentService.enrollInCourse(enrollmentRequest);
    }
}
