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
<c:forEach items="${sessionScope.minfolist}" var="x">
	<c:set var="h1" value="${x.height}"></c:set>
	<c:set var="h2" value="${x.weight}"></c:set>
	<c:set var="h3" value="${x.blood_group}"></c:set>
	<c:set var="h4" value="${x.diabetes}"></c:set>
	<c:set var="h5" value="${x.hypertention}"></c:set>
	<c:set var="h6" value="${x.asthama}"></c:set>
	<c:set var="h7" value="${x.disability}"></c:set>
	<c:set var="h8" value="${x.allergy}"></c:set>
</c:forEach>
<%@include file="dashboard-header.jsp" %>



<%@include file="common-navi.jsp" %> 


<div class="content">
	<div class="box">
		<table class="profile">
			<tr><th>Height</th><td>${h1} CM</td></tr>
			<tr><th>Weight</th><td>${h2} KG</td></tr>
			<tr><th>Blood Group</th><td>${h3}</td></tr>
			<tr><th>Diabetes</th><td>${h4}</td></tr>
			<tr><th>Hypertention</th><td>${h5}</td></tr>
			<tr><th>Asthama</th><td>${h6}</td></tr>
			<tr><th>Disability</th><td>${h7}</td></tr>
			<tr><th>Allergy</th><td>${h8}</td></tr>
			
		</table>
	</div>
	
</div>
<%@ include file="footer.jsp" %>
</body>
</html>