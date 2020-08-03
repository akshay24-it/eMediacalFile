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
	
		<form action="n_control?flag=insertnote&uid=${id}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Insert Notes</h1>
        		<hr>
        		<label for="date"><b>Date</b></label>
        		<input type="date" name="date" required>
        		<br>
        		<br>
        		<label for="notes" ><b>Notes</b></label>
        		<input type="text" name="note" required>
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>