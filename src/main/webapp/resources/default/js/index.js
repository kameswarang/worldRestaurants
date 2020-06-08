var getHome = axios.get("/home.faces")
    .then(function(r) {
        if(r != undefined && r.status == 200) {
            window.location.replace("/home.faces");
        }
        else {
            setTimeout(5000, getHome());
        }
    })

$(window).on("load", function($) {
    $("#error").toggle();
    getHome();
})