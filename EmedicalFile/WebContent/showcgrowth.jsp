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
<c:forEach items="${sessionScope.current}" var="i">
	<c:set var="uid" value="${i.id}"></c:set>
	<c:set var="height" value="${i.height}"></c:set>
	<c:set var="weight" value="${i.weight}"></c:set>
	<c:set var="sugar" value="${i.sugar}"></c:set>
	<c:set var="bloodpressure" value="${i.bloodpressure}"></c:set>

	
</c:forEach>
<%@include file="dashboard-header.jsp" %>



<%@include file="common-navi.jsp" %> 


<div class="content">
	<div class="box">
		<table class="profile">
			<tr><th>Height</th><td>${height} CM</td></tr>
			<tr><th>Weight</th><td>${weight} KG</td></tr>
			<tr><th>Sugar Level</th><td>${sugar} mmol/L</td></tr>
			<tr><th>Blood Pressure</th><td>${bloodpressure} mmHg</td></tr>
		
			
		</table>
	</div>
	
</div>
<%@ include file="footer.jsp" %>
</body>
</html>