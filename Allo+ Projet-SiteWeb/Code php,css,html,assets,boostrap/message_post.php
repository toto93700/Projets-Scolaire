<?php 
session_start();
require_once("dbConnexion.php");
if(isset($_POST['msgtxt']) && !empty($_POST['msgtxt']) ){
$q=$db->prepare("INSERT INTO message(msgtxt,IDowner,IDtopic,date_creation) VALUES(:msgtxt,:IDowner,:IDtopic,:date_creation)");
    $q->execute([
        'msgtxt'=>strval($_POST['msgtxt']),
        'IDowner'=>$_SESSION['ID_compte'],
        'IDtopic'=>$_POST['IDtopic'],
        'date_creation'=>date("Y-m-d")
    ]);
    header("Location: topic.php?IDtopic=$_POST[IDtopic]");
}
?>