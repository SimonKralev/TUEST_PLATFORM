package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Enrollment;
import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    @Override
    public EnrollmentResponse enrollInCourse(EnrollmentRequest enrollmentRequest) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent_id(enrollmentRequest.getStudent_id());
        enrollment.setCourse_id(enrollmentRequest.getCourse_id());
        enrollment.setRegistration_time(enrollmentRequest.getRegistration_time());

        EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
        enrollmentResponse.setStudent_id(enrollment.getStudent_id());
        enrollmentResponse.setCourse_id(enrollment.getCourse_id());
        enrollmentResponse.setRegistration_time(enrollment.getRegistration_time());

        return enrollmentResponse;
    }
}
