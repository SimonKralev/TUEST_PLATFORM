package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.CourseType;
import com.schoolplatform.demo.entities.CourseVisibility;
import com.schoolplatform.demo.models.CourseCreationRequest;
import com.schoolplatform.demo.models.CourseCreationResponse;
import com.schoolplatform.demo.repository.CourseRepository;
import com.schoolplatform.demo.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserService userService;

    @Override
    public CourseCreationResponse createCourse(CourseCreationRequest courseCreationRequest, Principal principal) {
        Course course = new Course();
        User user = userService.findUserByEmail(principal.getName());
        course.setUser(user);

        course.setTitle(courseCreationRequest.getTitle());
        course.setSubject(courseCreationRequest.getSubject());
        course.setDate(Timestamp.valueOf(courseCreationRequest.getDate()));
        course.setPrice(courseCreationRequest.getPrice());
        course.setType(CourseType.valueOf(courseCreationRequest.getType()));
        course.setVisibility(CourseVisibility.valueOf(courseCreationRequest.getVisibility()));

        if (courseCreationRequest.getLocation() == null) {
            course.setType(CourseType.ONLINE);
            course.setLocation(null);
        }
        else {
            course.setType(CourseType.IN_PERSON);
            course.setLocation(courseCreationRequest.getLocation());
        }

        courseRepository.save(course);
/*
        // automatically enrolling a teacher in the course which they created
        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
        enrollmentRequest.setCourse(course.getId());
        enrollmentRequest.setStudent(userService.findUserByEmail(principal.getName()).get().getId());
        enrollmentRequest.setRegistrationTime(String.valueOf(new Timestamp((new Date()).getTime())));
        enrollmentService.enrollInCourse(enrollmentRequest, principal);
*/
        CourseCreationResponse courseCreationResponse = new CourseCreationResponse();
        courseCreationResponse.setId(course.getId());
        courseCreationResponse.setUser(user);
        courseCreationResponse.setTitle(course.getTitle());
        courseCreationResponse.setSubject(course.getSubject());
        courseCreationResponse.setDate(course.getDate());
        courseCreationResponse.setLocation(course.getLocation());
        courseCreationResponse.setPrice(course.getPrice());
        return courseCreationResponse;
    }
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findCourseById(id);
    }

    @Override
    public List<Course> findAllByOrderByDateAsc() {
        return courseRepository.findAllByOrderByDateAsc();
    }
}
