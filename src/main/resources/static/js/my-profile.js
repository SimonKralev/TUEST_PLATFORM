"use strict";
$(function () {
    changeBio();
});

function changeBio() {
    $('.bio-form-group').on('click', '#change-bio-btn', function () {
        $('#bio').text("");
        $('#bio-form').append(
            "<span class='bio-table'>" +
            "<textarea type=\"text\" id=\"new-bio\" name=\"bio\" class=\"form-control\" placeholder=\"Bio\"/>\n" +
            "<!--button id=\"new-bio-btn\" class=\"btn form-submit\">Submit</button-->" +
            "</span>"
        );
        $('.bio-form-group').on('click', '#change-bio-btn', function () {
            let $bio = $("#new-bio").val();
            console.log('$("#new-bio").val() = ' + $bio );
            let requestBody = {
                "newBio": $bio
            };

            document.getElementById('bio-form').innerHTML = "";

            fetch("/my-profile/change-bio", {
                method: "POST",
                body: JSON.stringify(requestBody),
                headers: {
                    "Content-type": "application/json",
                    "Accept": "application/json, text/plain, */*"
                }
            })
                .then(response => {response.text()
                    .then(response => {
                        if (response === "error") {
                            toastr.error('Something went wrong. Try again!');
                        } else {
                            toastr.success(response);
                            $('#bio').text($bio);
                        }
                    })
                })
        })
    });
}