package com.schoolplatform.demo.services;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;

import java.security.Principal;

public interface EnrollmentService {
    int enrollInCourse(EnrollmentRequest enrollmentRequest, Principal principal);

    boolean existsByCourseIdAndStudentId(Long courseId, Long userId);
}
