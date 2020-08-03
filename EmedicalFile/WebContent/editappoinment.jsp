<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reg.css">

</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:forEach items="${sessionScope.edita }" var="i">
<c:set var="doctor" value="${i.doctor }"></c:set>
<c:set var="a_name" value="${i.a_name }"></c:set>
<c:set var="date" value="${i.date }"></c:set>
<c:set var="time" value="${i.time }"></c:set>
<c:set var="id" value="${i.id }"></c:set>
<c:set var="rid" value="${i.r_id.id}"></c:set>
</c:forEach>
<div class="form-main">
	
		<form action="a_control?flag=updateappoinment&uid=${id}&rid=${rid}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Update Appoinment Detail</h1>
        		<hr>
        		<b>Doctor name</b>
        		<select name="doctor" required>
        			<option>SELECT</option>
        			<c:forEach items="${sessionScope.doctor }" var="j">
        			<c:if test="${j.fn eq doctor }">
        				<option value="${j.fn }" selected="selected">${j.fn }</option>
        			</c:if>
        			<c:if test="${j.fn ne doctor }">
        				<option value="${j.fn }">${j.fn }</option>
        			</c:if>
        				
        			</c:forEach>
        		</select>
        		<br>
        		<br>
        		<label for="appoinment" ><b>Appoinment name</b></label>
        		<input type="text" name="appoinment" value="${a_name}" required>
        		
        		
        		<br>
        		<br>
        		<label for="date"><b>Date</b></label>
        		<input type="date" name="date" value="${date }" required>
        		<br>
        		<br>
        		<label for="time"><b>Time</b></label>
        		<input type="time" name="time" value="${time }" required>
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>