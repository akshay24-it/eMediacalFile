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
<c:forEach items="${sessionScope.editminfo}" var="x">
	<c:set var="id" value="${x.m_id}"></c:set>
	<c:set var="h1" value="${x.height}"></c:set>
	<c:set var="h2" value="${x.weight}"></c:set>
	<c:set var="h3" value="${x.blood_group}"></c:set>
	<c:set var="h4" value="${x.diabetes}"></c:set>
	<c:set var="h9" value="${x.sugar_level}"></c:set>
	<c:set var="h5" value="${x.hypertention}"></c:set>
	<c:set var="h10" value="${x.b_p}"></c:set>
	<c:set var="h6" value="${x.asthama}"></c:set>
	<c:set var="h7" value="${x.disability}"></c:set>
	<c:set var="h8" value="${x.allergy}"></c:set>
</c:forEach>

<div class="form-main">
	
		<form action="m_control?flag=updateminfo&uid=${id}" method="post" class="reg-form">
			<div class="form-sub">
				<h1>Edit Medical info</h1>
				<hr>
        		<label for="height" ><b>Height</b></label>
        		<input type="text" name="height" placeholder="CM" value="${h1 }" required>
        		
        		<label for="Weight"><b>Weight</b></label>
        		<input type="text" name="weight"  PLACEHOLDER="KG" value="${h2}" required>
        		
        		<label for="bloodgroup"><b>Blood Group</b></label>
        		<input type="text" name="bloodgroup" value="${h3}" required>
        		<br>
        		<label for="diabetes"><b>Diabetes</b></label>
        		<c:if test="${h4 eq 'yes'}">
        		<input type="radio" name="diabetes" value="yes" checked><label for="yes">Yes  </label>
        		<input type="radio" name="diabetes" value="no"><label for="no">No</label>
        		<br>
        		</c:if>
        		<c:if test="${h4 eq 'no'}">
        		<input type="radio" name="diabetes" value="yes"><label for="yes">Yes  </label>
        		<input type="radio" name="diabetes" value="no" checked><label for="no">No</label>
        		<br>
        		</c:if>
        		
        		
        		
        		<label for="sugar_level"><b>Sugar level</b></label>
        		<input type="text" name="sugar_level" placeholder="mmol/L" value="${h9 }" required>
        		<br>
        		
        		<c:if test="${h5 eq 'yes' }">
        		<label for="hypertention"><b>Hypertention</b></label>
        		<input type="radio" name="hypertention" value="yes" checked><label for="yes">Yes  </label>
        		<input type="radio" name="hypertention" value="no"><label for="no">No</label>
        		<br>
        		</c:if>
        		
        		<c:if test="${h5 eq 'no' }">
        		<label for="hypertention"><b>Hypertention</b></label>
        		<input type="radio" name="hypertention" value="yes"><label for="yes">Yes  </label>
        		<input type="radio" name="hypertention" value="no" checked><label for="no">No</label>
        		<br>
        		</c:if>
        		
        		
        		
        		<label for="bp"><b>Blood Pressure</b></label>
        		<input type="text" name="bp" placeholder="mmHg" value="${h10 }" required>
        		
        		<label for="asthama"><b>Asthama</b></label>
        		<input type="text" name="asthama" value="${h6 }" required>
        		
        		<label for="disability"><b>Disability</b></label>
        		<input type="text" name="disability" value="${h7 }" required>
        		
        		<label for="allergy"><b>Allergy</b></label>
        		<input type="text" name="allergy" value="${h8 }" required>
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>