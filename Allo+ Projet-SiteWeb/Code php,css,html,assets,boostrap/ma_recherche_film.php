<?php
session_start();
require_once("dbConnexion.php");
if(isset($_SESSION['ID_compte'])){
  require_once("menuoffcoandinsc.php");
}
else{
  require_once("menu.php");
}
?>
<!DOCTYPE html>
<html>
<?php 
$filmInterceptee;
$individuInterceptee;
$a=false;
$rechercheFini=false;

 $sql="SELECT * FROM film  WHERE Titre='$_GET[nom]'";
 
 $donnees=$db->query($sql); 
 $ficheFilms=$donnees->fetchAll(PDO::FETCH_OBJ);
 

 if($ficheFilms==null) {
    $filmInterceptee=false;
 }
else{   
     $_SESSION['ID_film']=$ficheFilms[0]->IDfilm;
     $filmInterceptee=true;
}
?>


<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="styleb.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="./etoileScript.js" defer> </script>
<meta charset ="utf -8" />
    <title>Allo ciné - Recherche de Film </title>
</head>
<body>
<div class="monStyle">
<?php


if($_GET['nom']==null){
  $rechercheFini=true;
}
/* --------------------- CAS OU LA RECHERCHE EST UN FILM ET QU'IL EXISTE DANS LA BDD ---------------*/ 
 if($filmInterceptee==true && $rechercheFini==false){ 
   foreach ($ficheFilms as $fiche) {
    ?> 
   
    <div class="box"> 
      <div class="afficheFilm">
      <img class="afficheFilm" src="<?=$fiche->img ?>" alt="imgfilm" style="width: 400px;height: 480px;margin-top: 2%;margin-bottom: 1%; border-radius: 15px;">
      </div>
    <h2>  <?=$fiche->Titre ?> </h2>
        <footer class="footer">

        <div class="bibox">
        Réalisateur : <a class="whiteText" href="/ma_recherche_film.php?nom=<?=$fiche->Realisateur ?>">  <?=$fiche->Realisateur ?> </a>
        </div>
        <div class="bibox">
        Annee de production : <?=$fiche->Annee ?>
        </div>
        <div class="bibox">
        Durée : <?=$fiche->Duree ?> min
        </div>
        <div class="bibox">
        Pays de production: <?=$fiche->ISO ?> 
        </div>
        <div class="bibox">
        <p>Liste d'acteur ayant participé au film :</p>

     <ul style="list-style-type: none">
<?php 
}
 /*   affichage  des donneé lié au acteur ayant joué dans le film   intercepté */

$rqt2="SELECT Nom,Prenom FROM individu WHERE FilmJouer LIKE '%$_GET[nom]%'";
$dataIndividus=$db->query($rqt2);
$individus=$dataIndividus->fetchAll(PDO::FETCH_OBJ);
   foreach($individus as $individu){
    ?>
        <li class="lienVersRecherche"><a class="whiteText" href="/ma_recherche_film.php?nom=<?= $individu->Nom?> ">  <?=$individu->Nom?> <?=$individu->Prenom ?>  </a></li>
<?php
   }
 ?>
    </ul>  
    <!--  /* code pour l'affichage des note de film  */  -->
<?php
   
     if(isset($_SESSION['ID_compte'])&& isset($_SESSION['ndc'])){
    $requser=$db->prepare("SELECT ID_compte,ndc FROM membre WHERE ID_compte=?");
    $requser->execute(array($_SESSION['ID_compte']));
    $userinfo=$requser->fetch();
   
    if($userinfo['ID_compte'] == $_SESSION['ID_compte'] && $userinfo['ndc']==$_SESSION['ndc']){
?>
        <div class="bibox">
       
        <span class="fas fa-star" data-star="1">     </span>
        <span class="fas fa-star" data-star="2">      </span>
        <span class="fas fa-star" data-star="3">     </span>
        <span class="fas fa-star" data-star="4">     </span>
        <span class="fas fa-star" data-star="5">      </span>
        note:<span class="rating">--</span>
        </div>
        
<?php }

}

?>
    <div class="bibox"> 
    <?php 
    $requser=$db->prepare("SELECT note FROM note_film WHERE IDfilm=?");
    $requser->execute(array($_SESSION['ID_film'] ));
    $noteTotal=$requser->fetchAll(PDO::FETCH_OBJ);
    $moy=0;
    if($requser->rowCount()>0){
      foreach($noteTotal as $note ){
        $moy+=$note->note;
      }
      $moy=$moy/$requser->rowCount();
    }
  ?>
     Note moyennes des utilisateurs : <?= intval($moy) ?> / 5
    </div>
    </div>                                                               
    </footer>
    </div>   
    <?php 
   $a=true;
} 
?> 



   <!--/*   ------------------------------------------------------------------------------------------------------ */
/*   ------------------------------------------------------------------------------------------------------ */    !-->

<?php 
if($rechercheFini==false){
$chaineEclatee=explode(" ",$_GET['nom'],3);

$cst;
?>
<?php

error_reporting(0);
if($chaineEclatee[1]==null){
  $cst=0;
}
else{
  $cst=1;
}
?>
<?php

$rqt3="SELECT Nom,Prenom,FilmJouer,img FROM individu WHERE Nom IN ('$chaineEclatee[0]','$chaineEclatee[$cst]') OR Prenom IN ('$chaineEclatee[0]','$chaineEclatee[$cst]')";
$dataIndividuss=$db->query($rqt3);
$individuInterceptee=$dataIndividuss->fetchAll(PDO::FETCH_OBJ);
    if($individuInterceptee==null){
     $rechercheFini=true;
    }
}

if($rechercheFini==false){
           /** <!--       CAS OU LA RECHERCHE CONCERNE  UN INDIVIDU                                 !-->*/
           $rechercheFini=true;
           foreach ($individuInterceptee as $individuT) {
            ?> 
           
            <div class="box"> 
        
            <h2>  <?=$individuT->Nom ?> <?=$individuT->Prenom ?> </h2>
                  <div>
                  <img class="afficheIndividu" src="<?=$individuT->img ?>">
                  </div>
                <footer class="footer">
                



                <?php if($individuT->FilmJouer!=null){ ?>
                    <div class="bibox">
                <!-- /* possibilité d'amleiorer le text  suivant en ajoutant des liens vers les films en question a faire plus tard */ !-->
                Liste des films dans lesquelles <a href="/ma_recherche_film.php?nom=<?=$individuT->Nom ?> <?=$individuT->Prenom ?>"> <?=$individuT->Nom ?> <?=$individuT->Prenom ?></a> à joué: 
                <?php 
                  foreach(explode(",",$individuT->FilmJouer) as $film){
                  ?>  <a href="/ma_recherche_film.php?nom=<?=$film?>"><?=$film?></a> |
                    <?php
                  }
                
                
                
                
                ?>
                </div>
              <?php 
             } ?>


             <?php 
             /* liste des film danslequel le getnom a  ete realisateur */ 
             $dataTitre=$db->query("SELECT Titre From film  WHERE  Realisateur IN ('$chaineEclatee[0]','$chaineEclatee[$cst]')");
             $TitreInterceptee=$dataTitre->fetchAll(PDO::FETCH_OBJ);
   
             if($TitreInterceptee!=null){
                 ?>
                <div class="bibox">
               liste des films dans lesquelles <a href="/ma_recherche_film.php?nom=<?=$individuT->Nom ?> <?=$individuT->Prenom ?>"> <?=$individuT->Nom ?> <?=$individuT->Prenom ?> </a> à été réalisateur:
                <?php 
                foreach($TitreInterceptee as $Titre){ 
                
                  ?>
                 
                <a href="/ma_recherche_film.php?nom=<?= $Titre->Titre ?>" ><?= $Titre->Titre ?> </a> 
             
                <?php 
                }
              }
                ?>
                </div>
               <?php 
            } 
              ?>
             
             </div>
             </footer>
           <?php 
           $a=true;
        } 
        ?>
             









 <!-- CAS OU LA RECHERCHE  A ECHOUER CAS: NEST NI UN FILM NI UN REALISATEUR/ACTEUR !--> 
 <?php

if($a==false) {
?>   
               <div class="topic" style="width:max-content;margin:0 auto; margin-top:10%">
        <h2>Aucun film , acteur/réalisateur de ce nom n'est connus de notre site  </h2>
             </div>
    
      <?php
      $rechercheFini==true;
}
?>

    </body>

</html>