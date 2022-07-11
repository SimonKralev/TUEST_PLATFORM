package com.schoolplatform.demo.services;

import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;

public interface EnrollmentService {
    public EnrollmentResponse enrollInCourse(EnrollmentRequest enrollmentRequest);
}
