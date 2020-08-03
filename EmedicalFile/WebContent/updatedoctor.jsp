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
<c:forEach items="${sessionScope.editd}" var="i">
	<c:set var="clinic" value="${i.clinic }"></c:set>
	<c:set var="fn" value="${i.fn }"></c:set>
	<c:set var="ln" value="${i.ln }"></c:set>
	<c:set var="email" value="${i.email }"></c:set>
	<c:set var="mob" value="${i.mob }"></c:set>
	<c:set var="gender" value="${i.gender }"></c:set>
	<c:set var="address" value="${i.address }"></c:set>
	<c:set var="degree" value="${i.degree }"></c:set>
	<c:set var="specialist" value="${i.specialist }"></c:set>
	<c:set var="experience" value="${i.experience }"></c:set>
	<c:set var="id" value="${i.id }"></c:set>
	<c:set var="rid" value="${i.r_id.id }"></c:set>
</c:forEach>
<div class="form-main">
	
		<form action="d_control?flag=updatedoctor&uid=${id}&rid=${rid}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Update Doctor Detail</h1>
        		<hr>
        		<label for="clinic" ><b>Clinic name</b></label>
        		<input type="text" name="clinic" value="${clinic }" required>
        		
        		<label for="firstname" ><b>First name</b></label>
        		<input type="text" name="fn" value="${fn }" required>
        		
        		<label for="lastname"><b>Last name</b></label>
        		<input type="text" name="ln" value="${ln }" required>
        		
        		<label for="email"><b>Email</b></label>
        		<input type="text" name="email" value="${email }" required>
        		
        		<label for="mob"><b>Mobile No</b></label>
        		<input type="text" name="mob" value="${mob }" required>
        		
        		<c:if test="${gender eq 'male' }">
        			<br>
	        		<label for="gender"><b>Gender&nbsp;&nbsp;</b></label>
	        		<input type="radio" name="gender" value="male" checked="checked"><label for="yes">Male&nbsp;&nbsp;&nbsp;</label>
	        		<input type="radio" name="gender" value="female"><label for="no">Female</label>
	        		<br>
        		</c:if>
        		
        		<c:if test="${gender eq 'female' }">
        			<br>
	        		<label for="gender"><b>Gender&nbsp;&nbsp;</b></label>
	        		<input type="radio" name="gender" value="male" ><label for="yes">Male&nbsp;&nbsp;&nbsp;</label>
	        		<input type="radio" name="gender" value="female" checked="checked"><label for="no">Female</label>
	        		<br>
        		</c:if>
        		
        		<label for="address"><b>Address</b></label>
        		<input type="text" name="address" value="${address }">
        		
        		<label for="degree"><b>Degree</b></label>
        		<input type="text" name="degree" value="${degree }">
        		
        		<label for="specialist"><b>Specialist</b></label>
        		<input type="text" name="specialist" value="${specialist }">
        		
        		<label for="exp"><b>Experience</b></label>
        		<input type="text" name="exp" value="${experience }">
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>