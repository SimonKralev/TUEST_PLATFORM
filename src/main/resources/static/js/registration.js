"use strict";
$(function () {
    registerUser();
});

function registerUser() {

    $(".register-form").on("click", "#register", function () {
        console.log("skndjs");
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
                console.log(response)
                if (response.status !== 200) {
                    toastr.error('Something went wrong. Try again!');
                } else {
                   location.replace("http://localhost:8080/login");
                }
            });
    });
}
