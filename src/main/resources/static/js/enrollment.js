"use strict";
$(function () {
    enrollInCourse();
});

function enrollInCourse() {

    $(".enroll").on("click", "#enroll", function () {
        let $student_id = "41";
        let $course_id = $course_id;
        let $registration_time = new Date().toISOString().slice(0, 19).replace('T', ' ');

        let requestBody = {
            "student_id": $student_id,
            "course_id": $course_id,
            "registration_time": $registration_time
        };

        fetch("/courses/" + $course_id, {
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
