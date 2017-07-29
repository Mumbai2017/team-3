<?PHP
require '../db_connect.php';


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
	$vcategory = 1;
	$vemail = "shraddha.mak1911@gmail.com";
	$reference = 1;
	$reason = "xyz";
	$prefloc = 1;
	$otherloc = "";
	$password = "12345";





	$SQL = "SELECT * FROM volunteer WHERE vemail = '$vemail' ";
            $result = mysqli_query($conn, $SQL);
            $num_rows = mysqli_num_rows($result);

            if ($num_rows > 0) {
            	$x = array("success"=>false, "message"=>"Oops! Volunteer Already exists.");
            	echo json_encode($x);
            } else {

                $SQL = "INSERT INTO volunteer (vcontact, vaddress, vcategory, vemail, reference, reason, prefloc, otherloc) VALUES ($vcontact, '$vaddress',$vcategory, '$vemail', $reference, '$reason', $prefloc, '$otherloc')";

				$result = mysqli_query($conn, $SQL);
				if($result == TRUE){
					$SQL = 
					$x = array("success"=>true, "message"=>"Successfully Signed Up.");					
					echo json_encode($x);
				}else{
	            	$x = array("success"=>false, "message"=>"Oops! Volunteer Already exists.");
	            	echo json_encode($x);
				}
                mysqli_close($conn);
               
            }
   

?>