<?PHP
require '../db_connect.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST'){
	$vid = $_POST['vid'];
	$vcontact = $_POST['vcontact'];
	$vaddress = $_POST['vaddress'];
	$vcategory = $_POST['vcategory'];
	$vemail = $_POST['vemail'];
	$reference = $_POST['reference'];
	$reason = $_POST['reason'];
	$prefloc = $_POST['prefloc'];
	$otherloc = $_POST['otherloc'];

	$SQL = "INSERT INTO volunteer (vid, vcontact, vaddress, vcategory, vemail, reference, ) VALUES ($vid, $vcontact, $vaddress,$vcategory, $vemail, $reference, $reason, $prefloc, $otherloc)";

	$result = mysqli_query($conn, $SQL);
}

?>