package com.schoolplatform.demo.repository;

import com.schoolplatform.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseById(Long id);
}
