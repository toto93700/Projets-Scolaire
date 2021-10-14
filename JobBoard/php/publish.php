<?php
require("dbConnexion.php");
$cst = 2;
if (isset($_GET['job'])) {
    if (isset($_GET['index'])) {
        if (empty($_GET['index'])) $_GET['index'] = 0;

        $sql1 = "SELECT * FROM advertissement WHERE nameJob=? AND city=? limit $cst OFFSET " . $_GET['index'];
        $sql2 = "SELECT * FROM advertissement WHERE nameJob=? limit $cst OFFSET " . $_GET['index'];
        $sql3 = "SELECT * FROM advertissement limit $cst OFFSET " . $_GET['index'];
        $sql4 = "SELECT * FROM advertissement WHERE city=? limit $cst OFFSET " . $_GET['index'];
        $done = false;

        if ($_GET['job'] == "load" || (empty($_GET['job']) && empty($_GET['city']))) {
            $query = $db->prepare($sql3);
            $query->execute();
            $done = true;
        }
        if (isset($_GET['city']) && !empty($_GET['city']) && empty($_GET['job']) && $done == false) {
            $query = $db->prepare($sql4);
            $query->execute(array($_GET['city']));
            $done = true;
        }
        if (isset($_GET['city']) && !empty($_GET['city']) && $done == false) {
            $query = $db->prepare($sql1);
            $query->execute(array($_GET['job'], $_GET['city']));
            $done = true;
        }
        if (empty($_GET['city']) && $_GET['job'] != "load" && $done == false) {
            $query = $db->prepare($sql2);
            $query->execute(array($_GET['job']));
        }
        if ($query->rowCount() <= 0) {
            http_response_code(400);
            exit;
        }
        $publishs = $query->fetchAll(PDO::FETCH_OBJ);
        foreach ($publishs as $publish) {
?>
            <html>
            <div class="col mb-5">
                <div class="card h-100 ">
                    <!-- Product image-->
                    <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!--name publish-->
                            <p class="font-weight-normal"><u><?= $publish->nameJob ?></u></p>
                            <h6 class=""><?= $publish->name ?> à <?= $publish->city ?></h6>
                            <!-- short description publish-->
                            <p class="description"><?= substr($publish->description, 0, 80) . "..."; ?></p>
                            <div class="eHiden" style="display:none"> <?= $publish->description ?> </div>
                        </div>

                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent text-center">
                        <div class=""><button type="button" class="btn btn-primary button_learnMore">Learn more</button></div>

                    </div>

                </div>
            </div>

            </html>

<?php
        }
    }
}
?>