"use strict";
$(function () {
    //getUpcomingCourses();
    //displayUpcomingCourses();
});

function getUpcomingCourses() {
    fetch ("/home/upcoming-courses", {
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Accept": "application/json, text/plain, */*"
        }
    })
        .then((response => response.json()))
        .then (function (response) {
            console.log("/home/upcoming-courses response: " + response);
            displayUpcomingCourses(response, response.length);
        })
        .catch ((err) => {
            console.log(err);
        });
}

function displayUpcomingCourses(courses, count) {
    console.log("in upcomingCourses()");
    console.log(courses);
    for (let i = 0; i < count; i++) {
       $('#upcoming-courses-container').append(
           "<div class=\"col-lg-4 col-md-6 col-sm-6\">\n" +
           "    <a href='courses/" + courses[i].id + "'>" +
           "        <div class=\"blog-item card mb-4 mb-lg-0 border-0\">\n" +
           "            <img src=\'../static/images/subjects/" + courses[i].displayableSubject + "' th:src='@{/images/subjects/" + courses[i].displayableSubject + "' alt='' class='img-fluid w-100'>\n" +
           "                <div class=\"blog-item-content p-4\">\n" +
           "                    <div class=\"blog-meta mb-2\">\n" +
           "                        <span><i class=\"ti-time mr-2\">" + courses[i].date + "</i></span>\n" +
           "                            <a href='" + courses[i].user.firstname + "-" + courses[i].user.lastname + "'>" + courses[i].user.firstname + " " + courses[i].user.lastname + "</a>\n" +
           "                     </div>\n" +
           "                     <h4 class=\"mt-2 mb-3\">" + courses[i].title + "</h4>\n" +
           "                 </div>\n" +
           "        </div>\n" +
           "    </a>\n" +
           "</div>");
    }
}