package com.schoolplatform.demo.services;
import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.Enrollment;
import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.models.EnrollmentRequest;
import com.schoolplatform.demo.models.EnrollmentResponse;
import com.schoolplatform.demo.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserService userService;
    private final CourseService courseService;


    @Override
    public int enrollInCourse(EnrollmentRequest enrollmentRequest, Principal principal) {
        System.out.println("In EnrollmentServiceImpl: enrollInCourse()");
        Enrollment enrollment = new Enrollment();

        User user = userService.findUserByEmail(principal.getName()).get();
        enrollment.setStudent(user);

        Course course = courseService.findCourseById(enrollmentRequest.getCourse());

        enrollment.setCourse(course);
        enrollment.setRegistrationTime(Timestamp.valueOf(enrollmentRequest.getRegistrationTime()));

        if (existsByCourseIdAndStudentId(course.getId(), user.getId())) {
            throw new IllegalArgumentException("User already enrolled");
        }

        enrollmentRepository.save(enrollment);

        EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
        enrollmentResponse.setStudent(enrollment.getStudent().getId());
        enrollmentResponse.setCourse(enrollment.getCourse().getId());
        enrollmentResponse.setRegistrationTime(enrollment.getRegistrationTime());

        return course.enrolledStudentsCount();
    }

    @Override
    public boolean existsByCourseIdAndStudentId(Long courseId, Long userId) {
        return enrollmentRepository.existsByCourseIdAndStudentId(courseId, userId);
    }
}