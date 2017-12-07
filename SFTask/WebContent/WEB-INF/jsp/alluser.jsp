<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body style="background: #e6e6fa;">

<h1 align="center">User List</h1>
	<table border="1" >
		<tr>
			<th>Login</th>
			<th>Password</th>
			<th>Role</th>
		</tr>
		

		<c:forEach var="user" items="${alluser }" >
				
					<tr>
						<td>
							<a href="UserForm?id=${user.user} ">
								${user.user}
							</a>
						</td>
						<td>
							${user.password}
						</td>
						<td>
							${user.role}
						</td>
					
					</tr>
					</c:forEach>
	
	</table>
	
		<form action="UserForm">
			<input type="submit" name="new" value="New">
		</form>
			

</body>
</html>


	