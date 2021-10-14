let hide = false;
let index = 0;
$.ajax({
  type: 'GET',
  url: '../php/publish.php',
  data: {
    'index': "0",
    'job': "load",
    'city': ""
  },
  success: function (data) {
    $(".sectionPublish").html(data);
    $(".button_learnMore").parent().append('<div class="mt-3"><aclass="link-info mt-3">Apply !</a></div>')
    $(".button_learnMore").on('click', function (e) {
      if (hide == false) {

        $(e.currentTarget).text("view other publish")
        $(".card-img-top").hide()
        $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".description").hide()
        $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".eHiden").show()
        $(e.currentTarget).parent().parent().parent().parent().parent().toggleClass()
        hide = true;
      }
      else {

        $(e.currentTarget).text("Learn More")
        $(".card-img-top").show()
        $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".description").show()
        $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".eHiden").hide()
        $(e.currentTarget).parent().parent().parent().parent().parent().toggleClass()
        hide = false
      }
      $(".button_LearnMore").parent().parent().parent().parent().parent().toggleClass()
      $(".button_LearnMore").parent().parent().parent().parent().parent().toggleClass()
      $(e.currentTarget).parents(".col").siblings().animate({
        height: 'toggle'
      })
    });
  },
  error: function (xhr, ajaxOptions, thrownError) {
  }
})

const val = 2
//permet la recherche des publication 
$("#btnResearch").on('click', function () {
  index = 0
  search(0)
})
$("#next").on('click', function () {
  index += val
  search(index)
  console.log(index)
})
$("#prev").on('click', function () {

  if (index - 1 >= 0) {
    index -= val
    search(index)
    console.log(index)
  }
  else {
    alert("no previous publishs")
  }
})



function search(i) {
  $.ajax({
    type: 'GET',
    url: '../php/publish.php',
    data: {

      'index': i.toString(),
      'job': $("#patternJob").val(),
      'city': $("#patern").val()
    },
    success: function (data, xhr) {

      $(".sectionPublish").empty().append(data);
      $(".button_learnMore").parent().append('<div class="mt-3"><a  class="link-info mt-3">Apply !</a></div>')
      $(".button_learnMore").on('click', function (e) {

        if (hide == false) {

          $(".card-img-top").hide()
          $(e.currentTarget).text("view other publish")
          $(e.currentTarget).parent().parent().parent().parent().parent().toggleClass()
          $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".description").hide()
          $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".eHiden").show()
          hide = true;

        }
        else {
          $(".card-img-top").show()
          $(e.currentTarget).text("Learn More")
          $(e.currentTarget).parent().parent().parent().parent().parent().toggleClass()

          $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".description").show()
          $(e.currentTarget).parents(".card").children(".card-body").children("div").children(".eHiden").hide()
          hide = false
        }
        $(".button_LearnMore").parent().parent().parent().parent().parent().toggleClass()
        $(".button_LearnMore").parent().parent().parent().parent().parent().toggleClass()
        $(e.currentTarget).parents(".col").siblings().animate({
          height: 'toggle'
        })
      });
    },
    error: function (xhr, ajaxOptions, thrownError) {
      $(".sectionPublish").empty().append('<div class="col blockquote"> <p class="text-center" > No(more) publishs for these args</p></div>');

    }
  })
}

// Permet l'autocompletion de ville 
$("#patern").on('keypress', function () {
  $.ajax({
    type: 'GET',
    url: '../php/cityApi.php',
    data: {
      'patern': $("#patern").val()
    },
    dataType: "json",
    success: function (data, textStatus, xhr) {
      console.log("donne recu")
      var dataName = JSON.parse(JSON.stringify(data));
      console.log(dataName)
      availableTags = [];
      for (const x in dataName) {
        console.log(x);
        availableTags.push(dataName[x]['city']);
      }
      $("#patern").autocomplete({
        source: availableTags
      })

    },
    complete: function (xhr, ajaxOptions, thrownError) {
    }
  })
})

// Permet l'autocompletion de metier
$("#patternJob").on('keypress', function () {
  $.ajax({
    type: 'GET',
    url: '../php/JobApi.php',
    data: {
      'patternJob': $("#patternJob").val()
    },
    dataType: "json",
    success: function (data, textStatus, xhr) {
      console.log("donne recu")
      var dataName = JSON.parse(JSON.stringify(data));
      console.log(dataName);
      availableTags = [];
      for (const x in dataName) {
        availableTags.push(dataName[x]['label']);
      }
      $("#patternJob").autocomplete({
        source: availableTags
      })

    },
    complete: function (xhr, ajaxOptions, thrownError) {
    }
  })
})

console.log(index)




//// Partie navigation

