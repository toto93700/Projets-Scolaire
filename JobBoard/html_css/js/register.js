
$(".btnRegister").on('click', function (e) {
    e.preventDefault();
    $.ajax({
        type: 'POST',
        url: '../php/register.php',
        data: {
            'email': $("#email").val(),
            'password': $("#password").val(),
            'name': $("#name").val(),
            'family_name': $("#family_name").val(),
            'phone': $("#phone").val(),
            'status': $("#status").val()
        },
        success: function (data, textStatus, xhr) {
            console.log($("#status").val())
            // if (xhr.status == 200) location.replace("./connect.html")
        },
        complete: function (xhr, textStatus) {
            if (xhr.status == 400) console.log("erreur");
        }

    })


});