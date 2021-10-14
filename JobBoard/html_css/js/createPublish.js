$("#createPublish").on('click', function (e) {
    e.preventDefault();
    $.ajax({
        type: 'POST',
        url: '../php/createPublish.php',
        data: {
            'email': $("#email").val(),
            'name': $("#name").val(),
            'city': $("#patern").val(),
            'job': $("#patternJob").val(),
            'phone': $("#phone").val(),
            'description': $("#description").val(),
        },
        success: function (data, textStatus, xhr) {

            if (xhr.status == 200) location.replace("./publish.html")
        },
        complete: function (xhr, textStatus) {
            if (xhr.status == 400) console.log("erreur");
        }

    })


});