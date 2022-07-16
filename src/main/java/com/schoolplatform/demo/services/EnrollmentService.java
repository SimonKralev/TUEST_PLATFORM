package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Enrollment;
import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

public interface EnrollmentService {
    int enrollInCourse(EnrollmentRequest enrollmentRequest, Principal principal);

    boolean existsByCourseIdAndStudentId(Long courseId, Long userId);

    List <Enrollment> findAllByCourseDateAfter(Timestamp currentTimestamp);
}
