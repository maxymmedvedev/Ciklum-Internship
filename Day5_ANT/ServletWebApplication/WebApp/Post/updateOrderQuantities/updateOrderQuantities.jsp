<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updateOrderQuantities</title>

</head>
<body>
	<h3><c:out value = "Product creation"/></h3>
	<form name="updateOrderQuantities" method="post" action="${appcontext}/WebApp/hello?action=updateOrderQuantities">
    		Order id: <br>
    		<input type="number" name="order_id"  min="1" required /> <br>
    		Product id: <br>
    		<input type="number" name="product_id" min="1" required/><br>
    		Set product quantity: <br>
    		<input type="number" name="product_quantity" min="1" required/><br>
    		
    <input type="submit" value="Submit" />
</form>
</body>
</html>