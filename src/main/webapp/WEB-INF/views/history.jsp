<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History</title>
</head>

<body>
<center>
<%@ include file = "header.jsp" %>
<h3>History</h3>
<c:if test="${!empty listHistory}">
	<table class="tg" border="1">
	<tr>
		<th width="80">History ID</th>
		<th width="120">Action Taken</th>
		<th width="120">Content</th>
		<th width="120">Content ID</th>
		<th width="120">User Name</th>
		
	</tr>
	<c:forEach items="${listHistory}" var="his">
		<tr>
			<td>${his.id}</td>
			<td>${his.remark}</td>
			<td>${his.updated_content}</td>
			<td>${his.content_id}</td>
			<td>${his.user.name}</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
</center>
</body>
</html>