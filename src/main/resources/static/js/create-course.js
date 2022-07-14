"use strict";
$(function () {
    createCourse();
});
function createCourse() {

    $(".create-course").on("click", "#create-course", function () {
        console.log("in createCourse()");
        let $title = $("#title").val();
        let $subject = $("#subject").val();
        //let $date = $("#date").val();
        let $date = $("#date").val() + " " + $("#time").val() + ":00";
        console.log($date);
        let $price = $("#price").val();
        let $location = $("#location").val();
        let $visibility = "PUBLIC";
        let $type = "IN_PERSON";
        /*if ($('#private-visibility-form-group').attr('checked', 'checked')) {
            console.log("private is checked");
            $visibility = "PRIVATE";
        }*/
        if ($('#agree-term').attr('checked', 'checked')) {
            $type = "ONLINE";
        }

        let requestBody = {
            "title": $title,
            "subject": $subject,
            "date": $date,
            "price": $price,
            "type": $type,
            "location": $location,
            "visibility": $visibility,
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