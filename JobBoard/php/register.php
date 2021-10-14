<?php
require("dbConnexion.php");




if (
    isset($_POST['email']) && isset($_POST['password']) && isset($_POST['name'])
    && isset($_POST['family_name']) && isset($_POST['phone']) && isset($_POST['status'])
    && !empty($_POST['password']) && !empty($_POST['email']) && !empty($_POST['name'])
    && !empty($_POST['family_name']) && !empty($_POST['phone']) && !empty($_POST['status'])
) {

    if ($_POST['status'] == "recruiter" || $_POST['status'] == "cand") {


        $existe = $db->prepare("SELECT id_people FROM people WHERE email=?");
        $existe->execute(array($_POST['email']));
        $userExiste = $existe->rowCount();

        if ($userExiste < 1) {
            echo ($userExiste);

            $rqt = $db->prepare("INSERT INTO `people` (`id_people`, `name`, `surname`, `email`, `phone`, `status`, `password`) 
        VALUES (NULL, :name, :family_name, :email , :phone, :status, :password)");
            $rqt->execute([
                'email' => $_POST['email'],
                'password' => $_POST['password'],
                'name' => $_POST['name'],
                'family_name' => $_POST['family_name'],
                'phone' => $_POST['phone'],
                'status' => $_POST['status']
            ]);
            http_response_code(200);
            exit;
        } else {
            http_response_code(400);
            exit;
        }
    }
} else {
    http_response_code(400);
    exit;
}
