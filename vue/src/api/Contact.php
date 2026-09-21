<?php

// **************************************************************
// Best Buds
// Processes contact form submissions
// **************************************************************

header("Content-Type: application/json");


// Allow POST requests only
if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    http_response_code(405);

    echo json_encode([
        "message" => "Method not allowed."
    ]);

    exit;
}


// Read the request body
$requestBody = file_get_contents("php://input");
$data = json_decode($requestBody, true);


// Validate the request body
if (!is_array($data)) {
    http_response_code(400);

    echo json_encode([
        "message" => "Invalid request."
    ]);

    exit;
}


// Stop basic bot submissions
if (!empty($data["website"])) {
    http_response_code(200);

    echo json_encode([
        "message" => "Message received."
    ]);

    exit;
}


// Clean the form values
$name = trim($data["name"] ?? "");
$email = trim($data["email"] ?? "");
$favoriteStrain = trim($data["favoriteStrain"] ?? "");
$message = trim($data["message"] ?? "");


// Validate required values
if (
    $name === "" ||
    $email === "" ||
    $message === ""
) {
    http_response_code(400);

    echo json_encode([
        "message" => "Please complete all required fields."
    ]);

    exit;
}


// Validate the email address
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    http_response_code(400);

    echo json_encode([
        "message" => "Please enter a valid email address."
    ]);

    exit;
}


// Validate field lengths
if (
    strlen($name) > 100 ||
    strlen($email) > 254 ||
    strlen($favoriteStrain) > 100 ||
    strlen($message) > 2000
) {
    http_response_code(400);

    echo json_encode([
        "message" => "One or more fields are too long."
    ]);

    exit;
}


// Build the email
$recipient = "YOUR_EMAIL_ADDRESS";
$subject = "Best Buds Contact Form";

$emailBody =
    "Name: " . $name . "\n" .
    "Email: " . $email . "\n" .
    "Favorite Strain: " . ($favoriteStrain ?: "Not provided") . "\n\n" .
    "Message:\n" . $message;


// Send the email
$headers = [
    "From: Best Buds <YOUR_SITE_EMAIL_ADDRESS>",
    "Reply-To: " . $email,
    "Content-Type: text/plain; charset=UTF-8"
];

$sent = mail(
    $recipient,
    $subject,
    $emailBody,
    implode("\r\n", $headers)
);


// Return the result
if (!$sent) {
    http_response_code(500);

    echo json_encode([
        "message" => "Message could not be sent."
    ]);

    exit;
}


echo json_encode([
    "message" => "Message sent successfully."
]);
