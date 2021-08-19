<?php 
require_once("dbConnexion.php");

?>
<?php

$loginIncorrect=true;

if(isset($_POST['formsend'])){
    $q=$db->prepare("SELECT ID_compte FROM membre WHERE ndc=? ");
    $q->execute(array($_POST['ndc']));
  
    $userExiste=$q->rowCount();
   
    if($userExiste<1){
    $q=$db->prepare("INSERT INTO membre(ndc,mdp) VALUES(:ndc,:mdp)");
    $q->execute([
        'ndc'=>$_POST['ndc'],
        'mdp'=>$_POST['mdp']
    ]);
    
    header("Location: connexion.php");
    
}
else{
    $loginIncorrect=false;
}
}
?>


<html>
<head>
    <title>Allo ciné - Inscription</title>
</head>
<body>
<?php require_once("menu.php"); ?>

      <div class="titre">
          Inscription
       </div>
       <?php

if($loginIncorrect == false){
    ?><p id="erreurMsg" style="margin-top:5px"> Identifiant déja utilsé veuillez en choisir un autre </p>
    <?php
}
?>
      <div class="formulaireInscriptionConnexion">
        <form method="post">
        <div>
            <input class="NDC" type="String" name="ndc" id ="ndc" placeholder ="identifiant" required>    
        </div>
        <div>
            <input class="MDP" type="password" name="mdp" id ="mdp" placeholder ="mot de passe" required>
        </div>
        <div>
            <input class="boutonSubmit"type="submit" name="formsend" id="formsend">
        </div>
        </form>
      </div>
</body>
</html>




