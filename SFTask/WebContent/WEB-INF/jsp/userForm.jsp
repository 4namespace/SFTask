<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user_form</title>
</head>
<body style="background: #e6e6fa;">


	<form action="UserSave" method="post">
		<input type="hidden" name= "oldUser" value ="${user.user }">
	 <table>
	  	<tr>
	 		<th>User:</th>
	 		<th><input name="user" value="${user.user}"> </th>
	 	</tr>
	 	<tr>
	 		<th>Password:</th>
	 		<th><input type="password"  name="password" value=""> </th>
	 	</tr>
	 	<tr>
	 		<th>Role:</th>
	 		<th><input name="role" value="${user.role}"> </th>
	 	</tr>
	 </table>
		<br><input type="submit" value="SAVE">
	</form>
	
			<form action="UserList">
			<input type="submit" name="backToMain" value="Back">
		    </form>
	<br>
	
	<c:if test="${user.user ne ''}">
	<form action="UserDelete" method ="post">
	<input type="hidden" name="trumpubpub" value="${user.user }">
	<input type="submit" value="delete">
	</form>
	</c:if>
	
</body>
</html>	       