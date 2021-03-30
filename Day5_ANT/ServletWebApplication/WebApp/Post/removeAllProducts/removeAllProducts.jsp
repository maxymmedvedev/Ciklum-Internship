<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>removeAllProducts</title>

</head>
<body>
	<h3><c:out value = "Deleting all products"/></h3>
	<form name="removeAllProducts" method="post" action="${appcontext}/WebApp/hello?action=removeAllProducts">
    		Enter your password: <br>
    		<input type="password" name="password" min="1" required/><br>
    		
    <input type="submit" value="Submit" />
</form>
</body>
</html>