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
	<c:out value = "${message}" escapeXml = "false" /> <br>
	<jsp:include page="${appContext}/hello?method=getProductsView" />
	
	<c:out value = " / "/>
	<a href="${appContext}/SpringWebApp/Post/removeProductById/removeProductByIdPage.jsp">Remove one more</a>
	
</body>
</html>