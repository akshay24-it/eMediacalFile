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
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:set value="${sessionScope.w}" var="i"></c:set>
<div class="form-main">
	<form action="r_control?flag=login" method="post" class="reg-form">
		<div class="form-sub">
		
				<h1>Login</h1>
        		<p>Please fill in this form for login</p>
        		<hr>
		
				<label for="user"><b>Username</b></label>
        		<input type="text" name="user" placeholder="enter username" required>
        		
        		<label for="pass"><b>Password</b></label>
        		<input type="password" name="pass" placeholder="enter password" required>
        		
        		<c:if test="${i ne null}">
        		<label style="color: red;">Wrong username and password</label><br>
				</c:if>
        		
        		<label>
        			<input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> 
        			Remember me
    		  	</label>
    		  	
    		  	<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
        		<label><a href="f_control?flag=cpass">forgot password ?</a></label>
		</div>
	</form>
</div>
<c:remove var="w"/>

</body>
</html>