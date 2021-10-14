<?php
include 'functions.php';
$pdo = pdo_connect_mysql();
$msg = '';
// Check if POST data is not empty
if (!empty($_POST)) {
    // Post data not empty insert a new record
    // Set-up the variables that are going to be inserted, we must check if the POST variables exist if not we can default them to blank
    $id_people = isset($_POST['id']) && !empty($_POST['id']) && $_POST['id'] != 'auto' ? $_POST['id'] : NULL;
    // Check if POST variable "name" exists, if not default the value to blank, basically the same for all variables
    $name = isset($_POST['name']) ? $_POST['name'] : '';
    $surname = isset($_POST['surname']) ? $_POST['surname'] : '';
    $email = isset($_POST['email']) ? $_POST['email'] : '';
    $phone = isset($_POST['phone']) ? $_POST['phone'] : '';
    $status = isset($_POST['status']) ? $_POST['status'] : '';
    // Insert new record into the contacts table
    $stmt = $pdo->prepare('INSERT INTO people VALUES (?, ?, ?, ?, ?, ?)');
    $stmt->execute([$id_people, $name, $surname, $email, $phone, $status]);
    // Output message
    $msg = 'Created Successfully!';
}
?>

<?=template_header('Create')?>

<div class="content update">
	<h2>Create Contact</h2>
    <form action="create.php" method="post">
        <label for="id">ID</label>
        <label for="name">Name</label>
        <input type="text" name="id_people" placeholder="26" value="auto" id="id_people">
        <input type="text" name="name" placeholder="John" id="name">
        <label for="email">Surname</label>
        <label for="phone">Email</label>
        <input type="text" name="Surname" placeholder="Smith" id="surname">
        <input type="text" name="email" placeholder="johnsmith@gmail.com" id="email">
        <label for="title">Phone</label>
        <label for="created">Status</label>
        <input type="tel" name="phone" placeholder="0652369689" id="phone">
        <input type="text" name="created" id="status">
        <input type="submit" value="Create">
    </form>
    <?php if ($msg): ?>
    <p><?=$msg?></p>
    <?php endif; ?>
</div>

<?=template_footer()?>