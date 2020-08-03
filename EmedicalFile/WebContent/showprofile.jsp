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
<c:forEach items="${sessionScope.listprofile}" var="i">
	<c:set var="uid" value="${i.id}"></c:set>
	<c:set var="fn" value="${i.firstname }"></c:set>
	<c:set var="ln" value="${i.lastname }"></c:set>
	<c:set var="mob" value="${i.mobileno }"></c:set>
	<c:set var="email" value="${i.email}"></c:set>
	<c:set var="gender" value="${i.gender }"></c:set>
	<c:set var="dob" value="${i.date }"></c:set>
	
</c:forEach>
<%@include file="dashboard-header.jsp" %>



<%@include file="common-navi.jsp" %> 


<div class="content">
	<div class="box">
		<table class="profile">
			<tr><th>First name</th><td>${fn }</td></tr>
			<tr><th>Last name</th><td>${ln }</td></tr>
			<tr><th>Mobile No</th><td>${mob }</td></tr>
			<tr><th>E-mail</th><td>${email }</td></tr>
			<tr><th>Date of birth</th><td>${dob }</td></tr>
			<tr><th>Gender</th><td>${gender }</td></tr>
			
		</table>
	</div>
	
</div>
<%@ include file="footer.jsp" %>
</body>
</html>