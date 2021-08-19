<?php session_start();
require_once("dbConnexion.php");

    $requser=$db->prepare("SELECT note FROM note_film WHERE IDfilm=? AND IDcompte=?");
    $requser->execute(array($_SESSION['ID_film'],$_SESSION['ID_compte']));
    $voteExiste=$requser->rowCount();

    if($voteExiste==0){    
        $requser=$db->prepare("INSERT INTO note_film(IDfilm,note,IDcompte) VALUES(:idfilm,:note,:idcompte)");
        $requser->execute([
            'idfilm'=>$_SESSION['ID_film'],
            'note'=>$_POST['rating'],
            'idcompte'=>$_SESSION['ID_compte']
        ]);
    }
    elseif($voteExiste==1){    

        $requser=$db->prepare("DELETE  FROM  note_film WHERE  IDfilm=? AND IDcompte=? ");
        $requser->execute(array($_SESSION['ID_film'],$_SESSION['ID_compte']));

        $requser=$db->prepare("INSERT INTO note_film(IDfilm,note,IDcompte) VALUES(:idfilm,:note,:idcompte)");
        $requser->execute([
            'idfilm'=>$_SESSION['ID_film'],
            'note'=>$_POST['rating'],
            'idcompte'=>$_SESSION['ID_compte']
        ]);
    }

?>