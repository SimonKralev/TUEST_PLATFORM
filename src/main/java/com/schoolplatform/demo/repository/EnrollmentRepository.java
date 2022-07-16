package com.schoolplatform.demo.repository;

import com.schoolplatform.demo.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    boolean existsByCourseIdAndStudentId(Long courseId, Long userId);

    List<Enrollment> findAllByCourseDateAfter(Timestamp currentTimestamp);
}
