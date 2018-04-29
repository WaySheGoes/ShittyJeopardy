<?php
	$username = "wight14";
	$password = "pecos";
	$dbName = "wight14";
	$address = "pi.cs.oswego.edu:3306";

  	if (!($link = mysqli_connect($address, $username, $password, $dbName))) {
    	echo "Unsuccessful Connection <br>";
   	 	exit;
  	}
  	echo "successful connection <br>";

  	$roundName = $_GET["PlayerName"];
  	$roundScore = $_GET["RoundScore"];

  	echo $roundName;
  	echo $roundScore;

	$insertStatement = "INSERT INTO RoundStats (PlayerName, Score) VALUES ('$roundName', '$roundScore')";

	
	if($link->query($insertStatement) === TRUE){
		echo "Record Creation Success";
	}else{
		echo "Error: " .link. "<br>" .$link->Error;
	}
	
 	mysqli_close($link);
?>