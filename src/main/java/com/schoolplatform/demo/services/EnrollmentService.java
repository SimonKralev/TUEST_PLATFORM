package com.schoolplatform.demo.services;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;

public interface EnrollmentService {
    EnrollmentResponse enrollInCourse(EnrollmentRequest enrollmentRequest);
}
