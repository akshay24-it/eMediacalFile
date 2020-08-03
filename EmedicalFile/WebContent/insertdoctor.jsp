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
	
		<form action="d_control?flag=insertdoctor&uid=${id}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Doctor Detail</h1>
        		<hr>
        		<label for="clinic" ><b>Clinic name</b></label>
        		<input type="text" name="clinic" required>
        		
        		<label for="firstname" ><b>Firstname</b></label>
        		<input type="text" name="fn" required>
        		
        		<label for="lastname"><b>Lastname</b></label>
        		<input type="text" name="ln" required>
        		
        		<label for="email"><b>Email</b></label>
        		<input type="text" name="email" required>
        		
        		<label for="mob"><b>Mobile No</b></label>
        		<input type="text" name="mob" required>
        		<br>
        		<label for="gender"><b>Gender&nbsp;&nbsp;</b></label>
        		<input type="radio" name="gender" value="male"><label for="yes">Male&nbsp;&nbsp;&nbsp;</label>
        		<input type="radio" name="gender" value="female"><label for="no">Female</label>
        		<br>
        		
        		
        		<label for="address"><b>Address</b></label>
        		<input type="text" name="address" required>
        		
        		<label for="degree"><b>Degree</b></label>
        		<input type="text" name="degree" required>
        		
        		<label for="specialist"><b>Specialist</b></label>
        		<input type="text" name="specialist" required>
        		
        		<label for="exp"><b>Experience</b></label>
        		<input type="text" name="exp" required>
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>