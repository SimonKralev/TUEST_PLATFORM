"use strict";
$(function () {
    createCourse();
});

function createCourse() {

    $(".create-course").on("click", "#create-course", function () {
        console.log("sdsds");
        let $title = $("#title").val();
        let $subject = $("#subject").val();
        let $date = $("#date").val();
        let $price = $("#price").val();
        let $location = $("#location").val();

        let requestBody = {
            "title": $title,
            "subject": $subject,
            "date": $date,
            "price": $price,
            "location": $location
        };

        fetch("/courses/create", {
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
                    console.log("Successfully created a course");
                    // redirect to the course
                }
            });
    });
}
