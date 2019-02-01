<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body>
<center>
<%@ include file = "header.jsp" %>
<br>
<h3>Please enter Username & Password</h3><br>

<font size="3" color="red">${msg}</font>
<form:form action="/ContentWriter/loginSubmit" method="POST">
<input type="text" class="form-control" name="username" placeholder="Username" required="required"/><br>
<input type="password" class="form-control" name="password" placeholder="Password" required="required"/> <br>    	
<input type="submit" value="login"/>  
</form:form>  
</center>
</body>
</html>