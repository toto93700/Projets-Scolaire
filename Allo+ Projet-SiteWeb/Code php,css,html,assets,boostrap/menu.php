
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<link rel="stylesheet" href="styleb.css">

 <!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.php" id="boutonAcceuil"> 
    <img src="assets/bouton_jaune_acceuil.jpg" width="30" height="24" alt="">
    Allo ciné 
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
                 <div id="barreRechercheAcceuil">
                    <form action="/ma_recherche_film.php" method="GET" class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="text" name="nom" placeholder="chercher un film/réalisateur" style="width:230px">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">ok</button>
                    </form>
                </div>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        
        <ul class="navbar-nav ml-md-auto">
           <li class="nav-item">
               <a class="nav-link" href="pageInscription.php">S'inscrire</a>
           </li>
           <li class="nav-item">
               <a class="nav-link" href="connexion.php">Se connecter</a>
           </li>   
        </ul>
        
    </div>
 </nav>  -->


 <div id="bandeauJaune">
    <div id="menuAccueil">
        <a href="index.php" id="boutonAcceuil"> 
        <img src="assets/bouton_jaune_acceuil.jpg" width="30" height="24" alt="" style="margin-right:5px;">Allo ciné</a>
    </div>
    <div id="barreRechercheAcceuilParent">
            <div class="barreRechercheAcceuil">
                <input id="rechercher"  type="text" name="nom" autocomplete="off" placeholder="chercher un film/réalisateur" style="width:230px">
                <div id="responseAutoCompletion">  </div>
            </div>
            <div class="barreRechercheAcceuil">
                <input type="button" value="rechercher" onclick="rechercher()"/>
            </div>
    </div>
    <div id="menuSinscrire"  class="linkMenu">
        <a  href="pageInscription.php">S'inscrire</a>
    </div>
    <div id="menuSeConnecter"  class="linkMenu">
        <a  href="connexion.php">Se connecter</a>
    </div>
 </div>
 

 
 <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
 <script>

     function rechercher(){
        var elementRechercher = document.querySelector("#rechercher");
        window.open("http://" + window.location.host + "/ma_Recherche_film?nom="+elementRechercher.value, "_self");
     }

 </script>

<script type="text/javascript">
  $(document).ready(function() {
    $("#rechercher").keyup(function() {
        var query= $("#rechercher").val();
        //console.log(query);
        if(query.length >1 ) {
            $.ajax(
                {
                    url:'autocompletion.php',
                    method:'POST',
                    data:{
                        q: query
                    },
                    success: function(data){
                        $("#responseAutoCompletion").html(data);
                        
                    },
                    dataType:'text'
                }
            );
        } 
    }); 
});

document.addEventListener("mouseup", function(event) {
    var obj = document.getElementById("responseAutoCompletion");
    var inputRechercher = document.getElementById("barreRechercheAcceuilParent");

    if (!obj.contains(event.target)) {
        $("#responseAutoCompletion").hide();
    }

    if(inputRechercher.contains(event.target)) {
        $("#responseAutoCompletion").show();
     }

});

</script>
