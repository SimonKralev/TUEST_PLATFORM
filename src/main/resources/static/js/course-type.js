function hideLocationInput() {
    if (document.getElementById("agree-term").checked) {
        document.getElementById("location-form-group").innerHTML = "";
    }
    else {
        document.getElementById("location-form-group").innerHTML = "<label><i class=\"zmdi zmdi-pin-drop\"></i></label>\n" +
            "                            <input type=\"text\" name=\"location\" id=\"location\" placeholder=\"Location\"/>";
    }
}