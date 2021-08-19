<?php 
    if (isset($_POST['q'])){
        $q=$_POST['q'];
        $response="";
        require_once("dbConnexion.php");
        $sql = "select concat(Nom,' ',Prenom) AS donnee FROM individu WHERE Nom LIKE '%$q%' OR Prenom LIKE '%$q%' UNION SELECT Titre FROM film WHERE Titre LIKE '%$q%'";
        $query=$db->query($sql);
        if($query->rowCount()>0){
            $Lesnoms=$query->fetchAll(PDO::FETCH_OBJ);
            
            foreach($Lesnoms as $nom){
                $response.="<div class='nomAutoCompletion'>";
                $response.=" <a class='blackText' href='/ma_recherche_film.php?nom=".$nom->donnee."'>".$nom->donnee."</a>";
                $response.="</div>";
            }
        }
   
         echo($response);
    }
    ?>

