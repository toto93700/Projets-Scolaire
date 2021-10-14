<?php
$db = new PDO('mysql:host=localhost;dbname=ville;charset=utf8', 'root', '');

if (isset($_GET["patern"]) && !empty($_GET["patern"])) {

    $query = "SELECT city FROM fr_1 WHERE city LIKE'" . $_GET['patern'] . "%' limit 5";

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
