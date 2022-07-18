"use strict";
$(function () {
    allowCourseCreating();
    addNavbar();
});

function allowCourseCreating() {
    $.ajax({
        url: "/my-profile/role",
        type: "GET",

        success: function (response) {
            console.log("/my-profile/role response: " + response);
            if (response === "login") {
                window.location = "/login";
            }
            if (response === "TEACHER") {
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

function addNavbar() {
    $('#mainmenu-area').append("<nav class=\"navbar navbar-expand-lg \">\n" +
        "     <div class=\"container align-items-center\">\n" +
        "      <a class=\"navbar-brand\" href=\"/home\">\n" +
        "       <h2 class=\"mb-0\"><span class=\"text-color\">Cours</span>ify</h2>\n" +
        "      </a>\n" +
        "      <!-- Toggler -->\n" +
        "      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarmain\" aria-controls=\"navbarmain\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
        "       <span class=\"ti-menu-alt\"></span>\n" +
        "      </button>\n" +
        "      <!-- Collapse -->\n" +
        "      <div class=\"collapse navbar-collapse text-center text-lg-left\" id=\"navbarmain\">\n" +
        "       <!-- Links -->\n" +
        "       <ul class=\"navbar-nav ml-auto\" id=\"navbar-ul\">\n" +
        "        <li class=\"nav-item\">\n" +
        "         <a href=\"/home\" th:href=\"@{/home}\" class=\"nav-link smoth-scroll\">\n" +
        "          Home\n" +
        "         </a>\n" +
        "        </li>\n" +
        "        <li class=\"nav-item\">\n" +
        "         <a href=\"/courses/all\" th:href=\"@{/courses/all}\" class=\"nav-link smoth-scroll\">\n" +
        "          Courses\n" +
        "         </a>\n" +
        "        </li>\n" +
        "        <li class=\"nav-item\">\n" +
        "         <a href=\"/about\" th:href=\"@{/about}\" class=\"nav-link smoth-scroll\">\n" +
        "          About\n" +
        "         </a>\n" +
        "        </li>\n" +
        "       </ul>\n" +
        "       <a href=\"/my-profile\" th:href=\"@{/my-profile}\" class=\"btn btn-border-tp btn-small ml-3\">My profile</a>\n" +
        "      </div>\n" +
        "     </div>\n" +
        "    </nav>");
}