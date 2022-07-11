package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.CourseType;
import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.models.CourseCreationRequest;
import com.schoolplatform.demo.models.CourseCreationResponse;
import com.schoolplatform.demo.repository.CourseRepository;
import com.schoolplatform.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public CourseCreationResponse createCourse(CourseCreationRequest courseCreationRequest) {
        Course course = new Course();
        User user = userRepository.findUserByEmail("irina04@gmail.com");
        course.setTeacher_id(user);
        course.setTitle(courseCreationRequest.getTitle());
        course.setSubject(courseCreationRequest.getSubject());
        course.setDate(courseCreationRequest.getDate());
        course.setPrice(courseCreationRequest.getPrice());
        if (courseCreationRequest.getLocation() == null) {
            course.setType(String.valueOf(CourseType.ONLINE));
            course.setLocation(null);
        }
        else {
            course.setType(String.valueOf(CourseType.IN_PERSON));
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
}
