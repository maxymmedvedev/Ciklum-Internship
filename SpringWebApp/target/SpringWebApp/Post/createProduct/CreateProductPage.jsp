<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Creation</title>
</head>
<body>
	
	<jsp:include page="${appContext}/hello?method=getProductsView" />
	<jsp:include page="/Post/createProduct/CreateProduct.jsp" />

</body>
</html>