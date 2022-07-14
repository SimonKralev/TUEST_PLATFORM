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

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserService userService;

    @Override
    public CourseCreationResponse createCourse(CourseCreationRequest courseCreationRequest) {
        Course course = new Course();
        Optional<User> user = userService.findUserByEmail("fibi@abv.bg");
        course.setUser(user.get());
        course.setTitle(courseCreationRequest.getTitle());
        course.setSubject(courseCreationRequest.getSubject());
        course.setDate(Timestamp.valueOf(courseCreationRequest.getDate()));
        course.setPrice(courseCreationRequest.getPrice());
        course.setType(CourseType.valueOf(courseCreationRequest.getType()));
        course.setVisibility(CourseVisibility.valueOf(courseCreationRequest.getVisibility()));;
        if (courseCreationRequest.getLocation() == null) {
            course.setType(CourseType.ONLINE);
            course.setLocation(null);
        }
        else {
            course.setType(CourseType.IN_PERSON);
            course.setLocation(courseCreationRequest.getLocation());
        }

        courseRepository.save(course);
        CourseCreationResponse courseCreationResponse = new CourseCreationResponse();
        courseCreationResponse.setTitle(course.getTitle());
        courseCreationResponse.setDate(course.getDate());
        return courseCreationResponse;
    }
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findCourseById(id);
    }
}