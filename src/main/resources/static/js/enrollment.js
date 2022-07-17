"use strict";
$(function () {
    console.log("in enrollment.js")
    enrollInCourse();
    enrollmentButton();
});

function enrollInCourse() {
    $(".course").on("click", '#enroll', function () {
        console.log("Trying to enroll");
        let $student_id = "1";
        let $course_id = String(course_id);
        let $registration_time = new Date().toISOString().slice(0, 19).replace('T', ' ');
        console.log($("#enrolledStudentsCount").text());
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
            .then((response => response.json()))
            .then(function (response) {
                if ($.isNumeric(response)) {
                    document.getElementById("enrolledStudentsCount").innerText = response;
                    document.getElementById("enroll").innerText = "Enrolled";
                    toastr.success("User successfully enrolled!");
                } else {
                    toastr.error("User already enrolled!");
                }
            })
    })
}

function enrollmentButton() {
    fetch ("/courses/" + course_id + "/user-enrolled", {
        method: "GET",
        headers: {
        "Content-type": "application/json",
            "Accept": "application/json, text/plain, */*"
        }
    })
        .then ((response => response.text()))
        .then (function (response) {
            console.log("/courses/" + course_id + "/user-enrolled response: " + response);
            document.getElementById("enroll").innerText = response;
            if (response === "Enrolled") {
                document.querySelector("#enroll").disabled = true;
            }
        })
        .catch ((err) => {
           console.log(err);
        });
}
