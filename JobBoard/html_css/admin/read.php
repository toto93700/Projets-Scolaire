<?php
include 'functions.php';
// Connect to MySQL database
$pdo = pdo_connect_mysql();
// Get the page via GET request (URL param: page), if non exists default the page to 1
$page = isset($_GET['page']) && is_numeric($_GET['page']) ? (int)$_GET['page'] : 1;
// Number of records to show on each page
$records_per_page = 5;
$stmt = $pdo->prepare('SELECT * FROM people ORDER BY id_people LIMIT :current_page, :record_per_page');
$stmt->bindValue(':current_page', ($page-1)*$records_per_page, PDO::PARAM_INT);
$stmt->bindValue(':record_per_page', $records_per_page, PDO::PARAM_INT);
$stmt->execute();
// Fetch the records so we can display them in our template.
$people = $stmt->fetchAll(PDO::FETCH_ASSOC);
$num_contacts = $pdo->query('SELECT COUNT(*) FROM people')->fetchColumn();
?>

<?=template_header('Read')?>

<div class="content read">
	<h2>Read Contacts</h2>
	<a href="create.php" class="create-contact">Create Contact</a>
	<table>
        <thead>
            <tr>
                <td>#</td>
                <td>Name</td>
                <td>Surname</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Status</td>
                <td></td>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($people as $people): ?>
            <tr>
                <td><?=$people['id_people']?></td>
                <td><?=$people['name']?></td>
                <td><?=$people['surname']?></td>
                <td><?=$people['email']?></td>
                <td><?=$people['phone']?></td>
                <td><?=$people['status']?></td>
                <td class="actions">
                    <a href="update.php?id=<?=$people['id_people']?>" class="edit"><i class="fas fa-pen fa-xs"></i></a>
                    <a href="delete.php?id=<?=$people['id_people']?>" class="trash"><i class="fas fa-trash fa-xs"></i></a>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
	<div class="pagination">
		<?php if ($page > 1): ?>
		<a href="read.php?page=<?=$page-1?>"><i class="fas fa-angle-double-left fa-sm"></i></a>
		<?php endif; ?>
		<?php if ($page*$records_per_page < $num_contacts): ?>
		<a href="read.php?page=<?=$page+1?>"><i class="fas fa-angle-double-right fa-sm"></i></a>
		<?php endif; ?>
	</div>
</div>

<?=template_footer()?>