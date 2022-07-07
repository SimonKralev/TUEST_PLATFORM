"use strict";
$(function () {
    registerUser();
});

function registerUser() {

    $(".register-form").on("click", "#register", function () {

        let $firstName = $("#firstName").val();
        let $lastName = $("#lastName").val();
        let $email = $("#email").val();
        let $password = $("#current-password").val();
        let $userType = $("#user-type").val();
        let $bio = $("#bio").val();

        let requestBody = {
            "firstname": $firstName,
            "lastname": $lastName,
            "email": $email,
            "password": $password,
            "userType": $userType,
            "bio": $bio
        };

        fetch("/register", {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                "Content-type": "application/json",
                "Accept": "application/json, text/plain, */*"
            }
        })
            .then((response) => {
                if (response.status !== 200) {
                    toastr.error('Something went wrong. Try again!');
                } else {
                    console.log("USPESHNO SE REGNAHME");
                }
            });
    });
}
