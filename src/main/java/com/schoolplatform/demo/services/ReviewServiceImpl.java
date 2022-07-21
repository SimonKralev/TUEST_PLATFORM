package com.schoolplatform.demo.services;

import com.schoolplatform.demo.entities.Review;
import com.schoolplatform.demo.models.ReviewRequest;
import com.schoolplatform.demo.models.ReviewResponse;
import com.schoolplatform.demo.repository.CourseRepository;
import com.schoolplatform.demo.repository.ReviewRepository;
import com.schoolplatform.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final CourseService courseService;

    @Override
    public ReviewResponse postReview(ReviewRequest reviewRequest, Principal principal) {
        Review review = new Review();
        review.setUser(userService.findUserByEmail(principal.getName()));

        review.setCourse(courseService.findCourseById(reviewRequest.getCourse()));
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());
        review.setTimeOfPosting(Timestamp.valueOf(reviewRequest.getTimeOfPosting()));
        try{
            review.setTimeOfPosting(Timestamp.valueOf(reviewRequest.getTimeOfPosting()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        reviewRepository.save(review);

        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setRating(review.getRating());
        reviewResponse.setComment(review.getComment());
        reviewResponse.setTimeOfPosting(review.getTimeOfPosting());

        return reviewResponse;
    }

    @Override
    public List<Review> findAllReviewsByCourseId(Long courseId) {
        List<Review> res = reviewRepository.findAllReviewsByCourseId(courseId);
        return res;
    }
}