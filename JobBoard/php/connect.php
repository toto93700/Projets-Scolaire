<?php
session_start();
require("dbConnexion.php");
if (isset($_POST['email']) && isset($_POST['password']) && !empty($_POST['password']) && !empty($_POST['email'])) {

    $rqt = $db->prepare("SELECT * FROM people WHERE email=? AND password=?");
    $rqt->execute(array($_POST['email'], $_POST['password']));
    $userexist = $rqt->rowCount();

    if ($userexist == 1) {
        $userinfo = $rqt->fetch();
        $_SESSION['email'] = $userinfo['email'];
        $_SESSION['password'] = $userinfo['password'];
        $_SESSION['name'] = $userinfo['name'];
        $_SESSION['surname'] = $userinfo['surname'];
        $_SESSION['status'] = $userinfo['status'];
        $_SESSION['id_people'] = $userinfo['id_people'];

        http_response_code(200);
        exit;
    } else {
        http_response_code(400);
        exit;
    }
}
