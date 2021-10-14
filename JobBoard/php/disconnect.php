<?php
session_start();
$_SESSION = array();
session_destroy();
header("Location: /html_css/index.html");
