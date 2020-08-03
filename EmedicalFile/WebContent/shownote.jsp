<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/dashboard-body.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/dash.css">
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@include file="dashboard-header.jsp" %>



<%@include file="common-navi.jsp" %> 


<div class="content">
	<div class="box">
		<table class="profile">
		<tr><th>Date</<th><th>Notes</th><th>Action</th></tr>
			<c:forEach items="${sessionScope.shown}" var="i">
				<tr>
					<td>${i.date }</td>
					<td>${i.note }</td>
					<td><a href="n_control?flag=deletenote&uid=${i.id }" style="text-decoration: none">Delete</a></td>
					
				</tr>
	
			</c:forEach>
			
			
		</table>
	</div>
	
</div>
<%@ include file="footer.jsp" %>
</body>
</html>