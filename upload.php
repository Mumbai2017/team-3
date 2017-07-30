<?php
 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 
 $image = $_POST['image'];
 
 require_once('db_connect.php');
 
 $sql = "INSERT INTO patient_photo (image) VALUES (?)";
 //echo $sql;
 $stmt = mysqli_prepare($conn,$sql);
 //echo $stmt;
 mysqli_stmt_bind_param($stmt,"s",$image);
 //echo $stmt;
 mysqli_stmt_execute($stmt);
 
 $check = mysqli_stmt_affected_rows($stmt);
 
 if($check == 1){
 echo "Image Uploaded Successfully";
 }else{
 echo "Error Uploading Image";
 }
 mysqli_close($conn);
 }else{
 echo "Error";
 }
 
 
 ?>
 