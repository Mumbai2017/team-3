<?PHP
	require '../db_connect.php';

	$jsonContacts = '{"shraddha":"9773919892", "Devika":"9819295737"}'
	$obj = json_decode($jsonContacts, true);

	echo $obj[0];

?>