<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Printing table</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/styles.css"/>
</head>
<body>
<table>
	<c:forEach items = "${dataOutput}" var = "collection">
		<tr>
		 
		<c:forEach items = "${collection}" var = "string">
		
		<td>
			<c:out value = "${string}"/>
		</td>
		
		</c:forEach>	

		</tr>
	</c:forEach>

</table>

</body>
</html>