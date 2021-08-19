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

<html>
<head>
<title> Allo cine : topics </title>
</head>



<?php
$q=$db->query(
    "SELECT * FROM message as m 
    RIGHT JOIN membre as me on m.IDowner=me.ID_compte 
    RIGHT JOIN topic as t on t.IDtopic=m.IDtopic
    WHERE t.IDtopic=$_GET[IDtopic]"
);
$lesMessages=$q->fetchAll(PDO::FETCH_OBJ);
?>
        
<?php

if(!empty($lesMessages[0]->msgtxt)){
    ?>
    <div class="titreForumTopic"> <?=  $lesMessages[0]->titre ?> </div>
    <?php
foreach($lesMessages as $message){
?>
   
        <div class="sectionMsgInfo">

            <div class="infoMsg">
                <div class="dateCreationMsg">
                posté le : <?=$message->date_creation?>
                </div>
                <div class="idUtilisateur">
                 Par :  <?= $message->ndc ?>
                </div>
            </div>

            <div class="messageTexte">
               <?= htmlspecialchars($message->msgtxt) ?>
            </div>
    </div>
<!----------------------------------------------------------------------------------------------------!-->

<?php
}
?>


<?php
}
else{
    ?> 

        <div class="titreForumTopic">
         <?=  $lesMessages[0]->titre ?> 
        </div>


        <div class="sectionNoMsgInfo">

            <div class="messageTexte">
              Aucun message sur ce Topic soyez le premier à en poster !
            </div>
    </div>

    
    <?php
}
?>

        <div class="sectionCommentaire">    

        <div class="baliseRepondre">
            Repondre
        </div>


        <div class="champsFormulaire">
            <form action="/message_post.php" method="POST" >
                <textarea  class="champtxt"  type="text" name="msgtxt" rows="5" cols="500"  placeholder="Pour que les discussions restent agréables, nous vous remercions de rester poli en toutes circonstances. En postant sur nos espaces, vous vous engagez à en respecter la charte d'utilisation. Tout message discriminatoire ou incitant à la haine sera supprimé et son auteur sanctionné" ></textarea>
                <input type="hidden" name="IDtopic" value="<?= $_GET["IDtopic"] ?>" />
                <div class="btnPoster">
                <button  type="submit">Poster</button>
                </div>
                
               
            </form>
        </div>
        </div>
</html>