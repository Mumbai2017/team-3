<?PHP
require 'db_connect.php';


//if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	// $uemail = $_POST['uemail'];
	// $pwd = $_POST['pwd'];
	$uemail = "abc@gmail.com";
	$pwd = "123";

	$SQL = "SELECT pwd FROM user WHERE uemail = '$uemail' ";
    $result = mysqli_query($conn, $SQL);
    $num_rows = mysqli_num_rows($result);

    if ($num_rows <= 0) {
        $x = array("success"=>false, "message"=>"Oops! User does not exist.");
           	echo json_encode($x);
    }
    else {
    	if ($pwd!=$result) {
			$x = array("success"=>false, "message"=>"Wrong password! Please re-enter.");
           		echo json_encode($x);
    }
    	}
    	else {
    	$SQL = "SELECT role from user where uemail = '$uemail' and pwd = '$pwd' ";
    	$result = mysqli_query($conn,$SQL);
    	if ($result == 'volunteer')  {
    		//header: ' Location: volunteer-login.php ';
    	}
    	else if ($result == 'donor')  {
    		//header: ' Location: donor-login.php ';
    	}
    	else if ($result == 'doctor')  {
    		//header: ' Location: doctor-login.php ';
    	}
    	else{

    	}

    	}    }
 //}

?>