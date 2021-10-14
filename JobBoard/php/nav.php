<?php
session_start();
if (isset($_SESSION['email']) && !empty($_SESSION['email']) && isset($_SESSION['password']) && !empty($_SESSION['password'])) {
?>
    <html>
    <div class="container">
        <a class="navbar-brand" href="#!">Job Board</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false"><?= $_SESSION['name'] . " " . $_SESSION['surname'] ?></a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="../html_css/profil.html">profil</a></li>
                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li><a class="dropdown-item" href="../html_css/publish.html">publish</a></li>
                        <li><a class="dropdown-item" href="../php/disconnect.php">disconect</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="../html_css/index.html">Home</a>
                </li>
                <?php if (isset($_SESSION['status']) && $_SESSION['status'] == "recruiter") {
                ?>
                    <li class="nav-item">
                        <a class="nav-link active" href="../html_css/createPublish.html">Create Publish</a>
                    </li>
                <?php
                }
                ?>
            </ul>
        </div>
    </div>

<?php
} else {
?>

    <html>
    <div class="container">
        <a class="navbar-brand" href="#!">Job Board</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">John Smith</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="../html_css/connect.html">Connect</a></li>
                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li><a class="dropdown-item" href="../html_css/register.html">Register</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="../html_css/index.html">Home</a>
                </li>

            </ul>
        </div>
    </div>

    </html>
<?php
}
?>