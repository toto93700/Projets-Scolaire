<?php
include 'functions.php';
$pdo = pdo_connect_mysql();
$msg = '';
// Check if the contact id exists, for example update.php?id=1 will get the contact with the id of 1
if (isset($_GET['id'])) {
    if (!empty($_POST)) {
        // This part is similar to the create.php, but instead we update a record and not insert
        $id_people = isset($_POST['id']) ? $_POST['id'] : NULL;
        $name = isset($_POST['name']) ? $_POST['name'] : '';
        $email = isset($_POST['surname']) ? $_POST['surname'] : '';
        $phone = isset($_POST['email']) ? $_POST['email'] : '';
        $title = isset($_POST['phone']) ? $_POST['phone'] : '';
        $created = isset($_POST['status']) ? $_POST['status'] : '';
        // Update the record
        $stmt = $pdo->prepare('UPDATE people SET id_people = ?, name = ?, surname = ?, email = ?, phone = ?, status = ? WHERE id_people = ?');
        $stmt->execute([$id_people, $name, $email, $phone, $title, $created, $_GET['id']]);
        $msg = 'Updated Successfully!';
    }
    // Get the contact from the contacts table
    $stmt = $pdo->prepare('SELECT * FROM people WHERE id_people = ?');
    $stmt->execute([$_GET['id']]);
    $people = $stmt->fetch(PDO::FETCH_ASSOC);
    if (!$people) {
        exit('Contact doesn\'t exist with that ID!');
    }
} else {
    exit('No ID specified!');
}
?>

<?=template_header('Read')?>

<div class="content update">
	<h2>Update Contact #<?=$people['id_people']?></h2>
    <form action="update.php?id=<?=$people['id_people']?>" method="post">
        <label for="id">ID</label>
        <label for="name">Name</label>
        <input type="text" name="id_people" placeholder="1" value="<?=$people['id_people']?>" id="id">
        <input type="text" name="name" placeholder="John Doe" value="<?=$people['name']?>" id="name">
        <label for="email">Surname</label>
        <label for="phone">Email</label>
        <input type="text" name="email" placeholder="johndoe@example.com" value="<?=$people['surname']?>" id="email">
        <input type="text" name="phone" placeholder="email" value="<?=$people['email']?>" id="phone">
        <label for="title">Phone</label>
        <label for="created">Status</label>
        <input type="tel" name="phone" placeholder="0689898545" value="<?=$people['phone']?>" id="phone">
        <input type="datetime-local" name="created" value="<?=date('Y-m-d\TH:i', strtotime($people['status']))?>" id="status">
        <input type="submit" value="Update">
    </form>
    <?php if ($msg): ?>
    <p><?=$msg?></p>
    <?php endif; ?>
</div>

<?=template_footer()?>