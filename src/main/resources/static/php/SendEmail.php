<!-- Cuando el usuario me envía un mensaje lo recibo en el gmail -->
<?php
$visitor_name = $_POST['mame'];
$visitor_email = $_POST['email'];
$subject = $_POST['subject'];
$message = &$_POST['email'];
$email_from = 'info@yourwebsite.com';
$email_subject = 'New Form Submission';
$email_body = "User Name: $visitor_name.\n" . "User Email: $visitor_email.\n" . "Subject: $subject.\n" . "User Message: $message.\n";
$to = 'javierborreguerodelpozo@gmail.com';
$headers = "From: $email_from \r\n";
$headers .= "Reply-To: $visitor_email \r\n";
mail($to, $email_subject, $email_body, $headers);
header("Location: /Contact");
?>


