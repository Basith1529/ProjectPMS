<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: auto;
        }
        .form-container h2 {
            text-align: center;
            color: #333;
        }
        .form-container input[type="text"],
        .form-container input[type="email"],
        .form-container input[type="tel"],
        .form-container input[type="number"],
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Customer Registration</h2>
        <form action="customerdetails.jsp" method="POST">
            
            <label for="cust_name">Full Name:</label>
            <input type="text" id="cust_name" name="cust_name" required>
            
            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="phone_number">Phone Number:</label>
            <input type="tel" id="phone_number" name="phone_number" required>
            
            <label for="street_address">Street Address:</label>
            <input type="text" id="street_address" name="street_address" required>
            
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required>
            
            <label for="state">State:</label>
            <input type="text" id="state" name="state" required>
            
            <label for="country">Country:</label>
            <input type="text" id="country" name="country" required>
            
            <label for="postal_code">Postal Code:</label>
            <input type="number" id="postal_code" name="postal_code" required>

            <input type="submit" value="Next">
        </form>
    </div>
</body>
</html>