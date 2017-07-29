<?PHP
require '../db_connect.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST'){
	// $vid = $_POST['vid'];
	// $vname = $_POST['vname']
	// $vcontact = $_POST['vcontact'];
	// $vaddress = $_POST['vaddress'];
	// $vcategory = $_POST['vcategory'];
	// $vemail = $_POST['vemail'];
	// $reference = $_POST['reference'];
	// $reason = $_POST['reason'];
	// $prefloc = $_POST['prefloc'];
	// $otherloc = $_POST['otherloc'];
	// $password = $_POST['password'];

	//$vid = $_POST['vid'];
	$vname = "Shraddha";
	$vcontact = 9773919892;
	$vaddress = "Mumbai,India";
	$vcategory = "abc";
	$vemail = "shraddha.mak1911@gmail.com";
	$reference = "abc.com";
	$reason = "xyz";
	$prefloc = "Mumbai";
	$otherloc = "";
	$password = "12345";



	$SQL = "SELECT * FROM volunteer WHERE vemail = '$vemail' ";
            $result = mysqli_query($conn, $SQL);
            $num_rows = mysqli_num_rows($result);

            if ($num_rows > 0) {
                $errorMessage = "Username already taken";
            } else {

                $SQL = "INSERT INTO volunteer (vcontact, vaddress, vcategory, vemail, reference, reason, prefloc, otherloc) VALUES ($vcontact, '$vaddress',$vcategory, '$vemail', $reference, '$reason', $prefloc, '$otherloc')";

				$result = mysqli_query($conn, $SQL);


                mysqli_close($conn);
               	$errorMessage = "";
                //header("Location: login.php");
            }
	
}

?>