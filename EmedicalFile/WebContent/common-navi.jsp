<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/dash.css">

<script>
 	var navbar = document.getElementById("navbar");
 	var sticky = navbar.offsetTop;
 	window.onscroll = function(){myFunction()};
 	function myFunction() {
 	  if (window.pageYOffset >= sticky) {
 	    navbar.classList.add("sticky")
 	  } else {
 	    navbar.classList.remove("sticky");
 	  }
 	}
</script>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:if test="${sessionScope.list ne null }">
	<c:forEach items="${sessionScope.list}" var="i">
		<c:set var="uid" value="${i.rid.id}"></c:set>
	</c:forEach>
</c:if>

<c:if test="${sessionScope.list eq null}">
	<c:forEach items="${sessionScope.listprofile}" var="j">
		<c:set var="uid" value="${j.id}"></c:set>
	</c:forEach>
</c:if>

<div id="navbar">

		<div class="dropdown">
		  	<button class="dropbtn"><b>Basic-info</b></button>
		 	<div class="dropdown-content">
		    <a href="r_control?id=${uid}&flag=showprofile">Profile</a>
		    <a href="r_control?id=${uid}&flag=editprofile">Edit Profile</a>
		    <a href="r_control?id=${uid}&flag=changepass">Change password</a>
		    <a href="home.jsp">Logout</a>
		  	</div>
		</div>

		<div class="dropdown">
		  	<button class="dropbtn"><b>Medical-info</b></button>
		 	<div class="dropdown-content">
		    <a href="m_control?id=${uid}&flag=showminfo">show medical info</a>
		    <a href="m_control?id=${uid}&flag=editminfo">edit medical info</a>
		  	</div>
		</div>
		
		<div class="dropdown">
		  	<button class="dropbtn"><b>Growth Status</b></button>
		 	<div class="dropdown-content">
		    <a href="m_control?id=${uid}&flag=current">Current Growth</a>
		    <a href="m_control?id=${uid}&flag=pre">Previous Growth</a>
		  	</div>
		</div>
		
		<div class="dropdown">
		  	<button class="dropbtn"><b>Vaccine</b></button>
		 	<div class="dropdown-content">
		    <a href="v_control?id=${uid }&flag=addvaccine">Add Vaccine</a>
		    <a href="v_control?id=${uid }&flag=showvaccine">Show Vaccine</a>
		  	</div>
		</div>
		
		<div class="dropdown">
		  	<button class="dropbtn"><b>Doctor</b></button>
		 	<div class="dropdown-content">
		    <a href="d_control?id=${uid}&flag=adddoctor">Add Doctor Details</a>
		    <a href="d_control?id=${uid}&flag=showdoctor">Show Doctor Detail</a>
		  	</div>
		</div>
		
		<div class="dropdown">
		  	<button class="dropbtn"><b>Appoinment</b></button>
		 	<div class="dropdown-content">
		    <a href="a_control?id=${uid }&flag=addappoinment">Add appoinment</a>
		    <a href="a_control?id=${uid }&flag=showappoinmnet">Show my appoinment</a>
		  	</div>
		</div>
		
		<div class="dropdown">
		  	<button class="dropbtn"><b>Medical Center</b></button>
		 	<div class="dropdown-content">
		    <a href="s_control?id=${uid }&flag=addstore">Add Medical Store</a>
		    <a href="s_control?id=${uid }&flag=showstore">Show Medical Store</a>
		  	</div>
		</div>
		
		<div class="dropdown">
		  	<button class="dropbtn"><b>Notes</b></button>
		 	<div class="dropdown-content">
		    <a href="n_control?id=${uid }&flag=addnotes">Add Notes</a>
		    <a href="n_control?id=${uid }&flag=shownotes">Show Notes</a>
		  
		  	</div>
		</div>

</div>

</body>
</html>