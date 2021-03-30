<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create order</title>

</head>
<body>
	<h3><c:out value = "Order creation"/></h3>
	<form name="createOrder" method="post" action="${appcontext}/WebApp/hello?action=createOrder">
    		Product id: <input type="number" name="product_id" required/> <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>