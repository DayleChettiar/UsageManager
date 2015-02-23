<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/jquery-ui-1.10.4.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>
<title>:: Update User Content::</title>
</head>
<body>
 <script>
 $(function() {
 $('input[name = "timeStamp"]').datepicker();
 });
 </script>

 <form method="POST" action='UserServlet' name="frmAddUser">
 
 ID : <input type="text" readonly="readonly" name="userId" value="<c:out value="${user.userId}" />" /> <br /> 
 Name : <input type="text" name="userName" value="<c:out value="${user.userName}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;<font size="3" color="red">Name can only contain alphabetic characters with an optional space</font><br /> 
 Email : <input type="text" name="email" value="<c:out value="${user.email}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;<font size="3" color="red">email ids have to have a set of alphanumerics with an <strong>'@'</strong> and a <strong>'.'</strong> in order </font> <br /> 
 Country : <input type="text" name="country" value="<c:out value="${user.country}" />" /> <br />
 Phone Number : <input type="text" name="phoneNumber" value="<c:out value="${user.phoneNumber}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;<font size="3" color="red">Phone numbers have to contain numbers with a <strong>'-'</strong> in between them</font> <br />
 Usage Type : <input type="text" name="usgType" value="<c:out value="${user.usgType}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;<font size="3" color="red"> DATA/VOICE/SMS <strong>all in uppercase. </strong></font> <br />
 Time Stamp  : <input type="text" name="timeStamp" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.timeStamp}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;<font size="3" color="red"> pattern= <strong>MM/dd/yyyy</strong></font><br />
  <input type="submit" value="Submit" /> &nbsp;&nbsp;&nbsp; <input type = "reset" value = "Reset">
 
 </form>
</body>
</html>