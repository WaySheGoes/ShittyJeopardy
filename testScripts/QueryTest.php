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
	  	echo "successful connection <br>";

		$selectStatement = "SELECT * FROM RoundStats";
		$result = $link->query($selectStatement);

		if($result->num_rows > 0){
			while($row = $result->fetch_assoc()){
				echo "Player Name: " . $row["PlayerName"]. " Score: " .$row["Score"]. "<br>";
			}
		}else{
			echo "No Results";
		}
		
	 	mysqli_close($link);
	?>
</body>
</html>