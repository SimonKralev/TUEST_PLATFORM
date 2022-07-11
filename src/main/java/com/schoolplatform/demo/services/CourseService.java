package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.models.CourseCreationRequest;
import com.schoolplatform.demo.models.CourseCreationResponse;

public interface CourseService {
    CourseCreationResponse createCourse(CourseCreationRequest courseCreationRequest);

    Iterable<Course> findAll();
}
