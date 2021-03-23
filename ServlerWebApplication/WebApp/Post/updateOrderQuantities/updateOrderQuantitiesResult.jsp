<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Quantities update</title>
</head>
<body>
	<c:out value = "${message}" escapeXml = "false" /> <br>
	<jsp:include page="${appContext}/hello?method=getOrdersView" />
	
	<c:out value = " / "/>
	<a href="${appContext}/WebApp/Post/updateOrderQuantities/updateOrderQuantitiesPage.jsp">Update one more</a>
	
</body>
</html>