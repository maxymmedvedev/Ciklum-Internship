<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordered Products View</title>

</head>
<body>
	<c:out value = "Ordered Products list:"/>
	<jsp:include page="printcontent.jsp" />

	<a href="${appContext}/SpringWebApp/index.jsp">Go back to main page</a>
</body>
</html>