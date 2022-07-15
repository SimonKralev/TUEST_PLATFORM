"use strict";
$(function () {
    allowCourseCreating();
});

function allowCourseCreating() {
    $.ajax({
        url: "/my-profile/role",
        type: "GET",

        success: function (response) {
            console.log("/my-profile/role response: " + response);
            if (response == "TEACHER") {
                $('#navbar-ul').append("<li class=\"nav-item\">\n" +
                    "                        <a href=\"/courses/create\" th:href=\"@{/courses/create}\" class=\"nav-link smoth-scroll\">\n" +
                    "                                    Create\n" +
                    "                        </a>\n" +
                    "                    </li>");
            }
        },
        error: function () {
            console.log('Something went wrong.');
        }
    })
}