$(".btnConnect").on('click', function (e) {
    e.preventDefault();
    $.ajax({
        type: 'POST',
        url: '../php/connect.php',
        data: {
            'email': $("#email").val(),
            'password': $("#password").val()
        },
        success: function (data, textStatus, xhr) {
            if (xhr.status == 200) location.replace("./index.html")
        },
        complete: function (xhr, textStatus) {
            if (xhr.status == 400) console.log("erreur");
        }
    })

})