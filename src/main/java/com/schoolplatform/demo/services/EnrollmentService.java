package com.schoolplatform.demo.services;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;

import java.security.Principal;

public interface EnrollmentService {
    EnrollmentResponse enrollInCourse(EnrollmentRequest enrollmentRequest, Principal principal);
}
