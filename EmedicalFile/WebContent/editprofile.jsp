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
<c:forEach items="${sessionScope.listprofile}" var="i">
	<c:set var="uid" value="${i.id}"></c:set>
	<c:set var="fn" value="${i.firstname }"></c:set>
	<c:set var="ln" value="${i.lastname }"></c:set>
	<c:set var="mob" value="${i.mobileno }"></c:set>
	<c:set var="email" value="${i.email}"></c:set>
	<c:set var="gender" value="${i.gender }"></c:set>
	<c:set var="dob" value="${i.date }"></c:set>
	
</c:forEach>

<div class="form-main">
		<form action="r_control?flag=updateprofile&id=${uid}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Edit Profile</h1>
<!--         		<p>Please fill in this form for edit Profile.</p> -->
        		<hr>
        		<label for="firstname"><b>First name</b></label>
        		<input type="text" name="fn" value="${fn}" required>
        		
        		<label for="lastname"><b>Last name</b></label>
        		<input type="text" name="ln" value="${ln }" required>
        		
        		<label for="email"><b>E-mail</b></label>
        		<input type="text" name="email" value="${email }" required>
        		
        		<label for="mobileno"><b>Mobile No</b></label>
        		<input type="text" name="mobile" value="${mob }" required>
        		
        		<label for="dob"><b>Birth Date</b></label>
        		<input type="date" name="dob" value="${dob }" required>
        		<br>
        		<br>
     
        		<c:if test="${gender eq 'male'}">
        		<label for="gender"><b>Gender</b></label>
        		<input type="radio" name="gender" value="male" checked><label for="male">Male  </label>
        		<input type="radio" name="gender" value="female"><label for="female">Female</label>
        		</c:if>
        		
        		<c:if test="${gender eq 'female'}">
        		<label for="gender"><b>Gender</b></label>
        		<input type="radio" name="gender" value="male"><label for="male">Male  </label>
        		<input type="radio" name="gender" value="female" checked><label for="female">Female</label>
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