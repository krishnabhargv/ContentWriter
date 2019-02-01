<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<%@ include file = "header.jsp" %>

<% int userId=(Integer)session.getAttribute("userId"); %>


<c:if test="${userId == null}">

				<li><a href="/ContentWriter/registration"> Sign Up</a></li>
      			<li><a href="/ContentWriter/login"> Login</a></li>
      			
			</c:if>
			<c:if test="${userId != null}">
			
			 <br>
			 <table>
			  <tr> <td><a href="/ContentWriter/writeContent"> Write Content</a> </td><td>:- Here you can write new contents, edit and remove privious contents. Hisory is also here so you can check all your contents history as well content specific history.</td></tr>
			    <tr><td> <a href="/ContentWriter/userList">View Users</a></td><td>:- Only ADMIN has right to access this page, Admin can update and delete users.</td></tr>
			     <tr><td><a href="/ContentWriter/logout">Logout</a></td></tr><br>
			   </table>
			</c:if> 
	
	 
	</body>
	</center>
</html>