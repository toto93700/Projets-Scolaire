$.ajax({
  type: 'POST',
  url: '../php/nav.php',
  success: function (data) {
    $(".navbar").html(data);
  },

  error: function (xhr, ajaxOptions, thrownError) {
  }
})
