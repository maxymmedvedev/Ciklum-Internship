<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Printing table</title>
<style>
	table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:first-child{
font-weight: bold;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
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