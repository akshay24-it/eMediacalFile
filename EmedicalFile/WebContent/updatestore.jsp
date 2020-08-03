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
<c:forEach items="${sessionScope.edits}" var="i">
	<c:set var="store" value="${i.store }"></c:set>
	<c:set var="on" value="${i.owner }"></c:set>
	<c:set var="email" value="${i.email }"></c:set>
	<c:set var="mob" value="${i.mob }"></c:set>
	<c:set var="address" value="${i.address }"></c:set>
	<c:set var="id" value="${i.id }"></c:set>
	<c:set var="rid" value="${i.r_id.id }"></c:set>
</c:forEach>
<div class="form-main">
	
		<form action="s_control?flag=updatestore&uid=${id}&rid=${rid}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Update Store Detail</h1>
        		<hr>
        		<label for="store" ><b>Medical Store name</b></label>
        		<input type="text" name="store" value="${store }" required>
        		
        		<label for="firstname" ><b>Owner name</b></label>
        		<input type="text" name="on" value="${on }" required>
        	
        		
        		<label for="email"><b>Email</b></label>
        		<input type="text" name="email" value="${email }" required>
        		
        		<label for="mob"><b>Mobile No</b></label>
        		<input type="text" name="mob" value="${mob }" required>
        		
        		<label for="address"><b>Address</b></label>
        		<input type="text" name="address" value="${address }" required>
        		
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>