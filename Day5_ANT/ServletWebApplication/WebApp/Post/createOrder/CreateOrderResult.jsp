<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders Creation</title>
</head>
<body>
	<c:out value = "${message}" escapeXml = "false"/> <br>
	<jsp:include page="${appContext}/hello?method=getOrdersView" />
	
	<c:out value = " / "/>
	<a href="${appContext}/WebApp/Post/createOrder/CreateOrderPage.jsp">Create one more</a>
	
</body>
</html>