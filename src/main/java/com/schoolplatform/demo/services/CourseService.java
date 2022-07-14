package com.schoolplatform.demo.services;
import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.models.CourseCreationRequest;
import com.schoolplatform.demo.models.CourseCreationResponse;

import java.security.Principal;

public interface CourseService {
    CourseCreationResponse createCourse(CourseCreationRequest courseCreationRequest, Principal principal);
    Iterable<Course> findAll();
    Course findCourseById(Long id);
}

