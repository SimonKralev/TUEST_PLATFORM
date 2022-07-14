package com.schoolplatform.demo.services;
import com.schoolplatform.demo.entities.Enrollment;
import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;
import com.schoolplatform.demo.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserService userService;
    private final CourseService courseService;

    @Override
    public EnrollmentResponse enrollInCourse(EnrollmentRequest enrollmentRequest) {
        System.out.println("In EnrollmentServiceImpl: enrollInCourse()");
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(userService.findUserById(7L).get());
        enrollment.setCourse(courseService.findCourseById(enrollmentRequest.getCourse()));
        enrollment.setRegistrationTime(Timestamp.valueOf(enrollmentRequest.getRegistrationTime()));

        enrollmentRepository.save(enrollment);

        EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
        enrollmentResponse.setStudent(enrollment.getStudent().getId());
        enrollmentResponse.setCourse(enrollment.getCourse().getId());
        enrollmentResponse.setRegistrationTime(enrollment.getRegistrationTime());

        return enrollmentResponse;
    }
}