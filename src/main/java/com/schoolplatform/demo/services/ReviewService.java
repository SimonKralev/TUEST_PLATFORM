package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Course;
import com.schoolplatform.demo.entities.Review;
import com.schoolplatform.demo.models.ReviewRequest;
import com.schoolplatform.demo.models.ReviewResponse;

import java.security.Principal;
import java.util.List;

public interface ReviewService {

    ReviewResponse postReview(ReviewRequest reviewRequest, Principal principal);

    List<Review> findAllReviewsByCourseId(Long courseId);
}

