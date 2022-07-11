<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="RegisterServlet">
		<input type="text" name="username" placeholder="Username"><br><br>
		<input type="text" name="password" placeholder="Password"><br><br>
		<input type="number" name="mobno" placeholder="Mobile Number"><br><br>
		<input type="text" name="email" placeholder="Email"><br><br>
		<input type="date" name="dob" placeholder="Date of Birth"><br><br>
		<input type="submit" name="button" value="Insert">
		<input type="submit" name="button" value="Update">
		<input type="submit" name="button" value="Delete">
	</form>
</body>
</html>
<!--  
<button type="submit" name="update">Update</button>
<button type="submit" name="delete">Delete</button>	-->