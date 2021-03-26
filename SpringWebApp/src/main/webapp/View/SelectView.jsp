<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select View</title>

</head>
<body>
	<c:set var = "appContext" value = "${pageContext.request.contextPath}"/>
<h3>Please select view</h3>
<ul>
  <li><a href="${appContext}/hello?method=getProductsView">Show products List</a></li>
  <li><a href="${appContext}/hello?method=getOrdersView">Show orders list</a></li>
  <li><a href="${appContext}/hello?method=getOrderedProductsView">Show ordered products list</a></li>
</ul> 
	
</body>
</html>