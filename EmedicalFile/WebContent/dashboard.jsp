<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/dash.css">
</head>
<body>

<%@include file="dashboard-header.jsp" %>

<%@include file="common-navi.jsp" %>



<div class="content">
	
</div>
<%@include file="footer.jsp" %>
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

</body>
</html>