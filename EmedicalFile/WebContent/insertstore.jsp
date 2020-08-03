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
<c:set var="id" value="${sessionScope.uid}"></c:set>
<div class="form-main">
	
		<form action="s_control?flag=insertstore&uid=${id}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Medical Store Detail</h1>
        		<hr>
        		<label for="store" ><b>Medical store name</b></label>
        		<input type="text" name="store" required>
        		
        		<label for="owner" ><b>Owner name</b></label>
        		<input type="text" name="on" required>
        
        		<label for="email"><b>Email</b></label>
        		<input type="text" name="email" required>
        		
        		<label for="mob"><b>Mobile No</b></label>
        		<input type="text" name="mob" required>
        		
        		
        		<label for="address"><b>Address</b></label>
        		<input type="text" name="address" required>
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>