<?php
session_start();
require_once("dbConnexion.php");
require_once("menuoffcoandinsc.php");
?>
<html>
<head>
    <title>Allo ciné - Profil</title>
</head>
<?php 
   
if(isset($_GET['id']) )
{
    $getid=intval($_GET['id']);  
    $requser=$db->prepare("SELECT ID_compte,mdp,ndc FROM membre WHERE ID_compte=?");
    $requser->execute(array($getid));
    $userinfo=$requser->fetch();
    
}
?>

<script scr="profil.js" defer> </script>


<?php  
if($userinfo['ID_compte'] == $_SESSION['ID_compte'] && $userinfo['ndc']==$_SESSION['ndc']){
?>
<div class="flexPorfil">
<div class="infoUser">
            Informations utilisateur
            </div>
<div class="styleTable">
            <div class="infoMdp">
             Mon ID : <?=$userinfo['ID_compte'] ?> 
            </div>
            <div class="infoNdc">
            Mon identifiant : <?= $userinfo['ndc'] ?>
            </div>

           
</div>
<div class="infoUser">
            Personalisation du profil
</div>
<div class="styleTable">
            <div class="choixCouleur">
            <span style="text-decoration:underline;">Ma couleur de fond </span>
            
                            <div>
                            <input type="radio" id="default" name="color" value="#eca201"
                                    checked onclick="init()">
                            <label for="default">Par défaut</label>
                            </div>

                            <div>
                            <input type="radio" id="red" name="color" value="red" onclick="init()">
                            <label for="red">Rouge</label>
                            </div>

                            <div>
                            <input type="radio" id="yellow" name="color" value="yellow" onclick="init()">
                            <label for="yellow">Jaune</label>
                            </div>
            
            </div> 
            </div>
            <div class="styleTable">
            <div class="choixPolice">
            <span style="text-decoration:underline">Ma police</span>
                         <div>
                                <input type="radio" id="defaultPolice" name="police" value="1"
                                    checked>
                                <label for="defaultPolice">Par défaut</label>
                            </div>
                            <div>
                                 <input type="radio" id="autrepolice" name="police" value="2">
                                <label for="autrepolice">Time new roman</label>
                            </div>
                         </div>
            </div>
            </div>
<?php
}
else{

    ?> hop hop hop ta rien à faire ici  <?php
}
?>

</html>