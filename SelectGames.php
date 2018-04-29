<?php
	$username = "wight14";
	$password = "pecos";
	$dbName = "wight14";
	$address = "pi.cs.oswego.edu:3306";

	if (!($link = mysqli_connect($address, $username, $password, $dbName))) {
	   	echo "Unsuccessful Connection <br>";
	 	exit;
	}
	
	$roundName = $_GET["PlayerName"];

	$xw = xmlwriter_open_memory();
	xmlwriter_set_indent($xw, 1);
	$res = xmlwriter_set_indent_string($xw, '	');
	xmlwriter_start_document($xw, '1.0', 'UTF-8');

	xmlwriter_start_element($xw, "games");
	/*
	$selectStatement = "SELECT PlayerName, Score FROM RoundStats WHERE PlayerName = '$roundName'";
	$result = $link->query($selectStatement);
	
	
	if($result->num_rows > 0){
		while ($row = $result->fetch_assoc()) {
			xmlwriter_start_element($xw, 'game')
			xmlwriter_start_element($xw, 'playerName')
			xmlwriter_text($xw, $row["PlayerName"]);
			xmlwriter_end_element($xw);
			xmlwriter_start_element($xw, 'score')
			xmlwriter_text($xw, $row["Score"]);
			xmlwriter_end_element($xw);
			xmlwriter_end_element($xw);
		}
	}else{
		echo "No Results";
	}
	*/
	xmlwriter_end_element($xw);
	xmlwriter_end_document($xw);
	mysqli_close($link);
	echo xmlwriter_output_memory($xw);
	
	
?>