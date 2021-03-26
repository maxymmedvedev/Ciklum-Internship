<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>removeProductById</title>

</head>
<body>
	<h3><c:out value = "Product removal"/></h3>
	<form name="removeProductById" method="post" action="${appcontext}/SpringWebApp/hello?action=removeProductById">
    		Product id: <br>
    		<input type="number" name="product_id"  min="1" required /> <br>
    		Password: <br>
    		<input type="password" name="password" min="1" required/><br>
    		
    <input type="submit" value="Submit" />
</form>
</body>
</html>