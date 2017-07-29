<?PHP
require 'db_connect.php';


//if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	// $uemail = $_POST['uemail'];
	// $pwd = $_POST['pwd'];
	// $role = $_POST['role'];

	$uemail = "abc@gmail.com";
	$pwd = "123";
	$role = "volunteer";

	$SQL = "SELECT * FROM user WHERE uemail = '$uemail' ";
    $result = mysqli_query($conn, $SQL);
    $num_rows = mysqli_num_rows($result);

    if ($num_rows > 0) {
        $x = array("success"=>false, "message"=>"Oops! User Already exists.");
           	echo json_encode($x);
    }
    else {
   	    $SQL = "INSERT INTO user (uemail, pwd, role) VALUES ('$uemail', '$pwd' ,'$role')";
   	    echo "Hello";
		$result = mysqli_query($conn, $SQL);
		if($result == TRUE){
			$x = array("success"=>true, "message"=>"Successfully Signed Up.");					
			echo json_encode($x);
		}else{
            $x = array("success"=>false, "message"=>"Oops! Error registering.");
            echo json_encode($x);
		}
        mysqli_close($conn);
    }
 //}

?>