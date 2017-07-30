<?php
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 $id = $_GET['id'];
 $sql = "select * from patient_photo where im_id = '$id'";
 require_once('db_connect.php');
 
 $r = mysqli_query($conn,$sql);
 
 $result = mysqli_fetch_array($r);
 
 header('content-type: image/jpeg');
 
 echo base64_decode($result['image']);
 
 mysqli_close($conn);
 
 }else{
 echo "Error";
 }
 
?>