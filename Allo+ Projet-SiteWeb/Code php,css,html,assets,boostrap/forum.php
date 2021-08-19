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

    <title>Allo ciné - Forum </title>

</head>
<body>

<div class="titreForum" >
   FORUM
</div>

<?php
$q=$db->query("SELECT * FROM topic order by date_creation desc");
$lesTopics=$q->fetchAll(PDO::FETCH_OBJ);
?>

<div class="topics" >
  <div id="nomTopics"> Topics  </div>
  <?php 
foreach($lesTopics as $topic){
  $liensuite=$topic->IDtopic;
    ?>
      <div class="topic">
        <div class="titreTopic"><a class="whiteText" href ="topic.php?IDtopic=<?=$liensuite?>" ><?=$topic->titre?> </a> </div>
        <div class="dateCreationTopic"> Crée le :  <?=$topic->date_creation ?> </div>
      </div>
     
  <?php
}
?>  
</div>


</body>
</html>