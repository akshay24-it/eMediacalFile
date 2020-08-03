<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/contact.css">
</head>
<body>

<%@include file="header.jsp" %>

<div class="container">
 
  <div class="row">
    
    <div class="column">
    
    
      <form action="">
        <label for="fname"><b>First Name</b></label>
        <input type="text" name="firstname" placeholder="Your name..">
        <label for="lname"><b>Last Name</b></label>
        <input type="text" name="lastname" placeholder="Your last name..">
        <label for="country">Country</label>
       <label for="email"><b>E-mail</b></label>
       <input type="text" name="email" placeholder="your email">
        <label for="subject"><b>Subject</b></label>
        <textarea id="subject" name="subject" placeholder="Write something.." style="height:170px"></textarea>
        <input type="submit" value="Submit">
      </form>
    </div>
  </div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>