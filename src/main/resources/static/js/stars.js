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