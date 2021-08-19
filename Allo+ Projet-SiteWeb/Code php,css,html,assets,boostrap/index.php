<?php 
session_start();
require_once("dbConnexion.php");
if(isset($_SESSION['ID_compte'])){
  require_once("menuoffcoandinsc.php");
}
else{
  require_once("menu.php");
}
$donnees=$db->query('SELECT * FROM `film` ORDER BY IDfilm desc LIMIT 3');
 $films=$donnees->fetchAll(PDO::FETCH_OBJ);

?>

<html>
<head>
    <title>Allo ciné </title>
</head>
<body>

    <div id="carouselExemple" class="carousel slide" data-ride="carousel" data-interval="4000">


        <div class="carousel-inner">

   

        <?php
        for($i=0;$i<count($films);$i++){
            if($i==0){  ?>  <div class="carousel-item active"> <?php }
            else{?> <div class="carousel-item">   <?php  }?>

        <h2>  <?=$films[$i]->Titre ?> </h2>
        <div>
            <img class="afficheFilm" src="<?=$films[$i]->img ?>" alt="imgfilm" style="width:400px;height: 480px;margin-top: 2%;margin-bottom: 1%; border-radius: 15px;">
        </div>
        <div>
        Réalisateur : <a class="whiteText" href="/ma_recherche_film.php?nom=<?=$films[$i]->Realisateur ?> "> <?=$films[$i]->Realisateur ?></a> 
        </div>
        <div>
        Annee de production : <?=$films[$i]->Annee ?>
        </div>
        <div>
        Durée : <?=$films[$i]->Duree ?> min
        </div>
        <div>
        Pays de production: <?=$films[$i]->ISO ?> 
        </div>
       
        </div>
        <?php 
        } ?>
        </div>

        <a href="#carouselExemple" class="carousel-control-prev" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a href="#carouselExemple" class="carousel-control-next" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>

    </div>


    
</body>

</html>