<?php
session_start();
require_once("dbConnexion.php");

$erreur=null;
if(isset($_POST['formsend']) AND $_POST['formsend']=='se connecter'){
    
    $connexionndc=$_POST['connexionndc'];
    $connexionmdp=$_POST['connexionmdp'];
    if(!empty($connexionndc) && !empty($connexionmdp)){

            $requser=$db->prepare("SELECT * FROM membre WHERE ndc=? AND mdp=?");
            $requser->execute(array($connexionndc,$connexionmdp));
            $userexist=$requser->rowCount();
          
            if($userexist==1)
                {
                   
                    $userinfo=$requser->fetch();
                    $_SESSION['ID_compte']=$userinfo['ID_compte'];
                    $_SESSION['ndc']=$userinfo['ndc'];
                    header("Location: profil.php?id=".$_SESSION['ID_compte']); 
                }
             else
                {
                    $erreur="mauvais MDP";
                }

            }
} 
?>
<html>
<?php require_once("menu.php"); ?>
<div>
    <p class="titre"> Connexion </p>
</div>
    <div class="formulaireInscriptionConnexion">

<form method="POST" action="">
<div>
    <input class="NDC" type="String" name="connexionndc"  placeholder ="identifiant" required>    
</div>
<div>
    <input class="MDP" type="password" name="connexionmdp" placeholder ="mot de passe" required>
</div>
<div>
    <input class="boutonSubmit"type="submit" name="formsend" id="formsend" value="se connecter">
</div>
</form>
<?php 
if(isset($erreur)){
    ?> 
                    <div id="erreurCo" style="color:red ; margin:0 auto; margin-top:15px; text-align:center " >
                        mauvais MDP ou NDC 
                     </div> 
                     
<?php   
}
?>
</div>
</html>