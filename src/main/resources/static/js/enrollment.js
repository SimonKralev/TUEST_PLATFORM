"use strict";
$(function () {
    console.log("in enrollment.js")
    enrollInCourse();
});

function enrollInCourse() {
    $(".course").on("click", '#enroll', function () {
        console.log("Trying to enroll");
        let $student_id = "1";
        let $course_id = String(course_id);
        let $registration_time = new Date().toISOString().slice(0, 19).replace('T', ' ');

        let requestBody = {
            "student": $student_id,
            "course": $course_id,
            "registrationTime": $registration_time
        };

        fetch("/courses/" + $course_id + "", {
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
                    console.log("Successfully enrolled in a course");
                    // redirect to the course
                }
            });
    });
}
