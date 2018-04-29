<?php

$xw = xmlwriter_open_memory();
/*
xmlwriter_set_indent($xw, 1);
$res = xmlwriter_set_indent_string($xw, ' ');

xmlwriter_start_document($xw, '1.0', 'UTF-8');

// A first element
xmlwriter_start_element($xw, 'tag1');

xmlwriter_end_element($xw);

// A processing instruction
xmlwriter_start_pi($xw, 'php');
xmlwriter_text($xw, '$foo=2;echo $foo;');
xmlwriter_end_pi($xw);

xmlwriter_end_document($xw);
*/
echo xmlwriter_output_memory($xw);

?>