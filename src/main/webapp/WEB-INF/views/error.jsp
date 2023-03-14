<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
    <!-- Add Bootstrap and Font Awesome CSS links -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        /* Center the error message */
        .error-message {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 50vh;
        }
    </style>
</head>
<body>
<div class="error-message">
    <!-- Add a large Font Awesome icon for the error -->
    <i class="fas fa-exclamation-triangle fa-5x mb-4 text-primary"></i>
    <!-- Add a description of the error -->
    <h1 class="text-primary">Error!</h1>
    <p>An error has occurred. Please try again later.</p>
</div>
<!-- Add Bootstrap and Font Awesome JS links (optional) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
