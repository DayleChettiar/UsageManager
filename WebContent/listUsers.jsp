<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; EUC-KR">
<title> :: User List :: </title>
</head>
<body>
  <table border=1>
 	<thead>
 		<tr>
		 	<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Country</th>
			<th>Phone Number</th>
			<th>Usage Type</th>
			<th>TimeStamp</th>
			<th colspan=2>Action</th>
		</tr>
	</thead>
 	<tbody>
 		<c:forEach items="${users}" var="user">
 			<tr>
 				<td><c:out value="${user.userId}" /></td>
				<td><c:out value="${user.userName}" /></td>
 				<td><c:out value="${user.email}" /></td>
 				<td><c:out value="${user.country}" /></td>
 				<td><c:out value="${user.phoneNumber}" /></td>
 				<td><c:out value="${user.usgType}" /></td>
 				<td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.timeStamp}" /></td>
 				<td><a href="UserServlet?action=edit&userId=<c:out value="${user.userId}"/>">Update</a></td>
 				<td><a href="UserServlet?action=delete&userId=<c:out value="${user.userId}"/>">Delete</a></td>
 			</tr>
 		</c:forEach>
 	</tbody>
  </table>
  <p><a href="UserServlet?action=insert">Add User</a></p>
  <br><br>
  <p><a href="UserServlet?action=search">Search User</a></p>
</body>
</html>