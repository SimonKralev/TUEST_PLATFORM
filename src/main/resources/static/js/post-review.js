"use strict";
var course_id = $(".course-container").attr('id');

$(function () {
    console.log("course_id = " + $(".course-container").attr('id'));
    postReview();
    getReviews();
    displayReviews();
});

function postReview() {
    $(".review-form").on("click", "#post-review", function () {
        console.log("in postReview()")
        let $comment = $("#comment").val();
        let $time_of_posting = new Date().toISOString().slice(0, 19).replace('T', ' ');
        let $rating = String(globalActiveStars);
        let $user_id = "2";
        let $course_id = String(course_id);

        let requestBody = {
            "user" : $user_id,
            "course" : $course_id,
            "rating" : $rating,
            "comment": $comment,
            "timeOfPosting": $time_of_posting
        };

        fetch("/courses/" + $course_id + "/post-review", {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                "Content-type": "application/json",
                "Accept": "application/json, text/plain, */*"
            }
        })
            .then((response) => {
                if (response.status !== 200) {
                    console.log('Something went wrong. Try again!');
                } else {
                    console.log("Successfully reviewed");
                }
            });
    });
}

// function getReviews() {
//     fetch("/courses/" + course_id + "/reviews", {
//         method: "GET",
//         headers: {
//             "Content-type": "application/json",
//             "Accept": "application/json, text/plain, */*"
//         }
//     })
//         .then((response) => response.json())
//         .then(function (response) {
//             console.log(response);
//             displayReviews(response);
//         })
//         .catch((err) => {
//             console.log(err.message)
//         })
// }

function getReviews() {
    $.ajax({
        url: "/courses/" + course_id + "/reviews",
        type: "GET",

        success: function (response) {
            console.log(response);
            console.log(response.length);
            displayReviews(response, response.length);

        },
        error: function () {
            console.log('Something went wrong.');
        }
    })
}

function displayReviews(reviews, count) {
    for (let i = 0; i < count; i++) {
        $("#review-section").append(
            '<div class="container">\n' +
            '<div class="col-lg-4 col-md-6 col-sm-6">' +
            '<div class="blog-item card mb-4 mb-lg-0 border-0">' +
            '<div class="star-rating-review review-item" id="review' + reviews[i].id + '">' +
            '<h3 class="">' + reviews[i].user.firstname + ' ' + reviews[i].user.lastname + '</h3>' +
            '<div class="blog-meta mb-2">' +
            '<span><i class="ti-time mr-2">' + reviews[i].timeOfPosting + '</i></span>' +
            '<a href="' + reviews[i].user.firstname + '-' + reviews[i].user.lastname + '"></a>' +
            '</div>' +
            '<h5 class="mt-2 mb-3">' + reviews[i].comment + '<a></a></h5>' +
            '</div>' +
            '</div>' +

            '</div>'
        )
        starRating(reviews[i].id, reviews[i].rating);
    }
}

function starRating(review_id, numberOfStars) {
    for (let i = 0; i < numberOfStars; i++) {
        $('#review' + review_id).append(
            '<span class="star active">&#9733;</span>'
        );
    }
    for (let i = 0; i < 5-numberOfStars; i++) {
        $('#review' + review_id).append(
            '<span class="star passive">&#9733;</span>'
        );
    }
}