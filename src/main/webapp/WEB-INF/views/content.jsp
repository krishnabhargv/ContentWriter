<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	
</head>
<body>
<center>
<%@ include file = "header.jsp" %>
<a href="<c:url value='/allHistory' />" ><h3 align="right">View All History</h3></a>
<form:form action="/ContentWriter/addContent" commandName="content">
<table>
	<c:if test="${!empty content.content}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="content">
				Write <spring:message text="content"/>(Must be less than 500 characters)
			</form:label>
		</td>
		<td>
			<form:textarea path="content" rows="5" cols="70" maxlength="499"/>
		</td> 
	
	
	
	
		<td colspan="15">
			<c:if test="${!empty content.content}">
				<input type="submit"
					value="<spring:message text="Edit Content"/>" />
			</c:if>
			<c:if test="${empty content.content}">
				<input type="submit"
					value="<spring:message text="Add Content"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>

<h3>Your Privious Content</h3>
<c:if test="${!empty listContents}">
	<table class="tg" border="1">
	<tr>
		<th width="80">ID</th>
		<th width="120">Content</th>
		<th width="80">User Name</th>
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
		<th width="60">History</th>
	</tr>
	<c:forEach items="${listContents}" var="content">
		<tr>
			<td>${content.id}</td>
			<td>${content.content}</td>
			<td>${content.user.name}</td>
			
			<td><a href="<c:url value='/editContent/${content.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeContent/${content.id}' />" >Delete</a></td>
			<td><a href="<c:url value='/history/${content.id}' />" >History</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</center>

</body>
</html>
