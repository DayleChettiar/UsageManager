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
<title>:: Select User ID and Usage Type::</title>
</head>
<body>
 
 <form method="POST" action='listUsers.jsp'>
 
 ID : <input type="text" name="userId" value="<c:out value="${user.userId}" />" /> <br /> 
 Usage Type : <input type="text" name="usgType" value="<c:out value="${user.usgType}" />" /> <br />
  <input type = "submit" name = "Submit" 
      value = "Browse Table Content">
    <input type = "reset" value = "Reset">
 
 </form>
</body>
</html>


