var globalActiveStars = 1;
function activateStars(starIndex) {
    let counter = 5;
    while(counter > 0) {
        document.getElementById("star" + counter).style.color = "#D4A373";
        counter--;
    }
    counter = starIndex;
    while(counter > 0) {
        document.getElementById("star" + counter).style.color = "#F56476";
        counter--;
    }
    globalActiveStars = starIndex;
}

function addCourseRating() {
    fetch ("/courses/" + course_id + "/course-rating", {
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Accept": "application/json, text/plain, */*"
        }
    })
        .then ((response => response.text()))
        .then( response => {
                console.log(response)
                $('#average-rating').text("Rated " + response + "/5");
            }
        )
        .catch ((err) => {
            console.log(err);
        });
}