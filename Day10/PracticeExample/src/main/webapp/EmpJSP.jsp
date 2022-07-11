<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="EmployeeServlet">
	
	<input type="number" name = "empno" placeholder="Empno"><br><br>
	<input type="text" name = "name" placeholder="Name"><br><br>
	<input type="number" name = "salary" placeholder="Salary"><br><br>
	<input type="date" name = "doj" placeholder="Date Of Joining"><br><br>
	<input type="submit" name="button" value="add">
	<input type="submit" name="button" value="delete">
	
	</form>
	
</body>
</html>