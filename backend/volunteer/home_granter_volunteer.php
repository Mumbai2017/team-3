<?PHP
require '../db_connect.php';


$pid = 1;
$vid = 7;
$did = 1;
$date_of_admit = "2017-07-01";
$date_of_identification = "2017-06-24";
$granted_or_not = "Yes";
$expected_date_of_fullfilment = "2017-07-10";
$rushwish = "Yes";
$w1_type = "I want to meet";
$w1_description = "I want to meet Ranbir Kapoor";
$w2_type = "I want to be";
$w2_description = "I want to be Police officer";
$w3_type = "I want to go to";
$w3_description = "I want to go to Disney Land"; 


 $SQL = "INSERT INTO wish (pid, vid, did, dtofadm, dtidf, granted, dateoffulfill, rushwish, wish1_type, w1desc, w2, w2desc, w3, w3desc) VALUES ('$pid','$vid','$did','$date_of_admit', '$date_of_identification','$granted_or_not', '$expected_date_of_fullfilment', '$rushwish', '$w1_type', '$w1_description', '$w2_type','$w2_description', '$w2_type','$w2_description')";

 $result = mysqli_query($conn, $SQL);

 if($result == TRUE){
 	
 	$SQL = "SELECT pid FROM volunteer_patient where vid=$vid";
 	$result = mysqli_query($conn, $SQL);
 	if($result == TRUE){
 		$rows = mysqli_fetch_all($result, MYSQLI_NUM);
 		//echo json_encode($rows);
 		echo $rows['0']['0'];
 		$i=0;
 		foreach ($rows as $onerow){
 			echo $onerow[0];
 			$qry = "SELECT pname FROM patients where pid = '$onerow[$i]'";
 			//echo $qry;
 			$res = mysqli_query($conn, $qry);
 			//echo $res;
 			$ans = mysqli_fetch_array($res);
 			$pname = $ans['pname'];
 			echo $ans['pname'];
 			//echo $qry;
 			$i++;
 		}
 	}

 }




?>