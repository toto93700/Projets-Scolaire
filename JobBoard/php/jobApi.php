<?php
$db = new PDO('mysql:host=localhost;dbname=ville;charset=utf8', 'root', '');
//Offset: value
if (isset($_GET["patternJob"]) && !empty($_GET["patternJob"])) {

    $query = "SELECT label  FROM metier WHERE label LIKE'" . $_GET['patternJob'] . "%' limit 5";

    $rqt = $db->prepare($query);
    $rqt->execute();
    $datas = $rqt->fetchAll();
    header('Content-Type: application/json; charset=utf-8');

    echo (json_encode(
        $datas
    ));
    http_response_code(200);
    exit;
}
http_response_code(400);
