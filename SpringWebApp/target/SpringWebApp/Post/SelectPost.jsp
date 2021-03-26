<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select action</title>

</head>
<body>
	<c:set var = "appContext" value = "${pageContext.request.contextPath}"/>
<h3>Please select action</h3>
<ul>
 	<li><a href="Post/createOrder/CreateOrderPage.jsp">Create Order</a></li>
 	<li><a href="Post/createProduct/CreateProductPage.jsp">Create product</a></li>
  	<li><a href="Post/updateOrderQuantities/updateOrderQuantitiesPage.jsp">Change product quantity in order</a></li>
  	<li><a href="Post/removeProductById/removeProductByIdPage.jsp">Remove Product By Id</a></li>	
  	<li><a href="Post/removeAllProducts/removeAllProductsPage.jsp">Remove All Products</a></li>	


</ul> 
  <%--	
  <li><a href="${appContext}/hello?method=getOrdersView">Show orders list</a></li>
  <li><a href="${appContext}/hello?method=getOrderedProductsView">Show ordered products list</a></li>
  --%>
	
</body>
</html>