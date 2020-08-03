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
	
		<form action="m_control?flag=medicalinfo&uid=${id}" method="post" class="reg-form">
			<div class="form-sub">
	
        		<label for="height" ><b>Height</b></label>
        		<input type="text" name="height" placeholder="CM">
        		
        		<label for="Weight"><b>Weight</b></label>
        		<input type="text" name="weight"  PLACEHOLDER="KG">
        		
        		<label for="bloodgroup"><b>Blood Group</b></label>
        		<input type="text" name="bloodgroup">
        		<br>
        		<label for="diabetes"><b>Diabetes</b></label>
        		<input type="radio" name="diabetes" value="yes"><label for="yes">Yes  </label>
        		<input type="radio" name="diabetes" value="no"><label for="no">No</label>
        		<br>
        		
        		
        		<label for="sugar_level"><b>Sugar level</b></label>
        		<input type="text" name="sugar_level" placeholder="mmol/L">
        		<br>
        		<label for="hypertention"><b>Hypertention</b></label>
        		<input type="radio" name="hypertention" value="yes"><label for="yes">Yes  </label>
        		<input type="radio" name="hypertention" value="no"><label for="no">No</label>
        		<br>
        		
        		
        		<label for="bp"><b>Blood Pressure</b></label>
        		<input type="text" name="bp" placeholder="mmHg">
        		
        		<label for="asthama"><b>Asthama</b></label>
        		<input type="text" name="asthama">
        		
        		<label for="disability"><b>Disability</b></label>
        		<input type="text" name="disability">
        		
        		<label for="allergy"><b>Allergy</b></label>
        		<input type="text" name="allergy">
        		
        		<div class="btn">
        			<button type="submit">Submit</button>
        			<button type="reset" class="resetbtn">Reset</button>
        		</div>
        		
			</div>
		</form>
	
</div>
</body>
</html>