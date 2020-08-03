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
<c:forEach items="${sessionScope.editv }" var="i">
<c:set var="vaccine" value="${i.vname }"></c:set>
<c:set var="disease" value="${i.disease }"></c:set>
<c:set var="date" value="${i.date }"></c:set>
<c:set var="d_date" value="${i.d_date }"></c:set>
<c:set var="id" value="${i.id }"></c:set>
<c:set var="rid" value="${i.r_id.id}"></c:set>
</c:forEach>
<div class="form-main">
	
		<form action="v_control?flag=updatevaccine&uid=${id}&rid=${rid}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Update Vaccine Detail</h1>
        		<hr>
        		<b>Vaccine name</b>
        		
          		<label for="vaccine" ><b>Vaccine name</b></label>
        		<input type="text" name="vaccine" value="${vaccine}" required>
        		
        		<label for="disease" ><b>Disease name</b></label>
        		<input type="text" name="disease" value="${disease}" required>
        		<br>
        		<br>
        		<label for="date"><b>Dose Date</b></label>
        		<input type="date" name="date" value="${date }" required>
        		<br>
        		<br>
        		<label for="d_date"><b>Next Dose Date</b></label>
        		<input type="date" name="d_date" value="${d_date }" required>
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>