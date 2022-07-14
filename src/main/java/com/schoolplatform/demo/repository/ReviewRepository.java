package com.schoolplatform.demo.repository;

import com.schoolplatform.demo.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    //boolean existsByCourseIdAndUserId (int postId, int userId);

    //Rating findByUserIdAndPostId (int userId, int postId);
    List<Review> findAllReviewsByCourseId(Long courseId);
}
