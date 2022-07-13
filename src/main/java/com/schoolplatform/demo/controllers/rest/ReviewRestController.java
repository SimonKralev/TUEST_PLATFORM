package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.entities.Review;
import com.schoolplatform.demo.models.ReviewRequest;
import com.schoolplatform.demo.models.ReviewResponse;
import com.schoolplatform.demo.repository.ReviewRepository;
import com.schoolplatform.demo.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @PostMapping("/courses/{course_id}/post-review")
    public ReviewResponse postReview(@RequestBody ReviewRequest reviewRequest, @PathVariable("course_id") String course_id){
        System.out.println("ReviewRestController: course_id = " + course_id);
        reviewRequest.setCourse(Long.valueOf(course_id));
        return reviewService.postReview(reviewRequest);
    }

    @GetMapping("/courses/{course_id}/reviews")
    public List<Review> displayReviews(@PathVariable String course_id) {
        return reviewService.findAllReviewsByCourseId(Long.valueOf(course_id));
    }

}

