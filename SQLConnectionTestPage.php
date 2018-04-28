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
	    	echo "Unsuccessful Connection";
	   	 	exit;
	  	}
	  	echo "successful connection";
	 	mysqli_close($link);
	?>
</body>
</html>