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
<c:set var="id" value="${sessionScope.vaccine}"></c:set>
<div class="form-main">
	
		<form action="v_control?flag=insertvaccine&uid=${id}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Insert Vaccine Detail</h1>
        		<hr>
        		
        		<label for="vaccine" ><b>Vaccine name</b></label>
        		<input type="text" name="vaccine" required>
        		
        		<label for="disease" ><b>Disease name</b></label>
        		<input type="text" name="disease" required>
        		
        		<br>
        		<br>
        		<label for="date"><b>Vaccine Date</b></label>
        		<input type="date" name="date" required>
        		<br>
        		<br>
        		<label for="d_date"><b>Next Dose Date</b></label>
        		<input type="date" name="d_date">
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>