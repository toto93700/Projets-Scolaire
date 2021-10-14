<?php
session_start();
require('dbConnexion.php');
if ($_SESSION['status'] == "recruiter") {
    if (
        isset($_POST['email']) && isset($_POST['name']) && isset($_POST['description'])
        && isset($_POST['city']) && isset($_POST['phone']) && isset($_POST['job'])
        && !empty($_POST['email']) && !empty($_POST['name'])
        && !empty($_POST['phone']) && !empty($_POST['city']) && !empty($_POST['job']) && !empty($_POST['description'])
    ) {
        $rqt = $db->prepare("INSERT INTO `advertissement` (`name`, `mail`, `phone`, `city`, `nameJob`, `description`,`id_people`) 
        VALUES (:name, :mail ,:phone,:city,:nameJob,:description,:id_people)");
        $rqt->execute([
            'name' => $_POST['name'],
            'mail' => $_POST['email'],
            'phone' => $_POST['phone'],
            'city' => $_POST['city'],
            'nameJob' => $_POST['job'],
            'description' => $_POST['description'],
            'id_people' => $_SESSION['id_people'],
        ]);

        http_response_code(200);
        exit;
    }
} else {
    http_response_code(400);
    exit;
}
