<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create product</title>

</head>
<body>
	<h3><c:out value = "Product creation"/></h3>
	<form name="createProduct" method="post" action="${appcontext}/SpringWebApp/hello?action=createProduct">
    		Product name: <br>
    		<input type="text" name="product_name" required /> <br>
    		Product price: <br>
    		<input type="number" name="product_price" min="0" required/><br>
    		<input type="radio" id="1" name="product_status" value="out_of_stock" required>Out of stock<br> 
    		<input type="radio" id="1" name="product_status" value="in_stock">In stock<br>
    		<input type="radio" id="1" name="product_status" value="running_low">Running low<br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>