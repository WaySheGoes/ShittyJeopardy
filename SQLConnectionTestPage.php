<!DOCTYPE html>
<html>
<head>
	<title>SQL Connection</title>
	<style type="text/css">
		html, body{
			height: 100%;
			width: 100%;
			margin: 0;
			padding: 0;
		}
	</style>
</head>
<body>
	<?php
		$username = "wight14";
		$password = "pecos";
		$dbName = "wight14";
		$address = "pi.cs.oswego.edu:3306";

	  	if (!($link = mysqli_connect($address, $username, $password, $dbName))) {
	    	echo "Unsuccessful Connection <br>";
	   	 	exit;
	  	}
	  	echo "successful connection";

		$insertStatement = "INSERT INTO RoundStats (PlayerName, Score) VALUES ('Haroldine', '550')";

		if($link->query($insertStatement) === TRUE){
			echo "Record Creation Success";
		}	else{
			echo "Error: " .$link. "<br>" . $link->error;
		}
	 	mysqli_close($link);
	?>
</body>
</html>