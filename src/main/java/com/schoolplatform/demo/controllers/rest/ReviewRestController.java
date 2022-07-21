package com.schoolplatform.demo.controllers.rest;

import com.schoolplatform.demo.entities.Review;
import com.schoolplatform.demo.entities.User;
import com.schoolplatform.demo.models.ReviewRequest;
import com.schoolplatform.demo.models.ReviewResponse;
import com.schoolplatform.demo.services.CourseService;
import com.schoolplatform.demo.services.ReviewService;
import com.schoolplatform.demo.services.UserService;
import com.schoolplatform.demo.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final UserService userService;

    @PostMapping("/courses/{course_id}/post-review")
    public ReviewResponse postReview(@RequestBody ReviewRequest reviewRequest, @PathVariable("course_id") Long courseId, Principal principal){
        System.out.println("ReviewRestController: course_id = " + courseId);
        reviewRequest.setCourse(courseId);
        return reviewService.postReview(reviewRequest, principal);
    }

    @GetMapping("/courses/{course_id}/reviews")
    public List<Review> displayReviews(@PathVariable("course_id") String courseId) {
        return reviewService.findAllReviewsByCourseId(Long.valueOf(courseId));
    }

    @GetMapping("/courses/{course_id}/reviews-allowed")
    public boolean userEnrolledAndCourseEnded(@PathVariable("course_id") Long courseId, Principal principal) {
        if (courseService.findCourseById(courseId).getDate().before(new Timestamp((new Date()).getTime()))) {
            User user = userService.findUserByEmail(principal.getName());
            if (enrollmentService.existsByCourseIdAndStudentId(courseId, user.getId())) {
                return true;
            }
        }
        return false;
    }

}
