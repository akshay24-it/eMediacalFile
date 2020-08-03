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
<c:set var="uid" value="${sessionScope.cpassid }"></c:set>
<c:set var="i" value="${sessionScope.wp}"></c:set>
<div class="form-main">
		<form action="r_control?flag=updatepass&id=${uid}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Change Password</h1>
        		
        		<hr>
        		<label for="old"><b>Old password</b></label>
        		<input type="password" name="opass">
        		
        		<label for="new"><b>New Password</b></label>
        		<input type="password" name="npass">
        		
        		<label for="confirm"><b>Confirm Password</b></label>
        		<input type="password" name="cpass">
        		
        		<c:if test="${i ne null}">
        		<label style="color: red;">${i}</label><br>
				</c:if>
				
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>