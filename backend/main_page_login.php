<?PHP
require 'db_connect.php';


//if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	// $uemail = $_POST['uemail'];
	// $pwd = $_POST['pwd'];
	$uemail = "Shraddha@gmail.com";
	$pwd = "12345";

	$SQL = "SELECT pwd FROM user WHERE uemail = '$uemail' ";
	$result = mysqli_query($conn, $SQL);
	$row = mysqli_fetch_array($result);
    $user_pwd = $row['pwd'];
    $num_rows = mysqli_num_rows($result);

    if ($num_rows <= 0) {
        $x = array("success"=>false, "message"=>"Oops! User does not exist.");
        echo json_encode($x);
    }
    else {
    	if ($pwd!=$user_pwd) {
			$x = array("success"=>false, "message"=>"Wrong password! Please re-enter.");
          	echo json_encode($x);
    	}
    	else {
    		$SQL = "SELECT role from user where uemail = '$uemail' and pwd = '$pwd' ";
    		$result = mysqli_query($conn,$SQL);
    		$row = mysqli_fetch_array($result);
    		$role = $row['role'];

    		if ($role == 'volunteer')  {
    			
    			echo "volunteer";
    		// $x = array("uid"=>, "message"=>"Oops! User does not exist.");
      		// echo json_encode($x);
    		}
    		else if ($result == 'donor')  {
    			//header: ' Location: donor-login.php ';
    		}
    		else if ($result == 'doctor')  {
    			//header: ' Location: doctor-login.php ';
    		}
    		else{

    		}

    	}    
    }
 //}

?>