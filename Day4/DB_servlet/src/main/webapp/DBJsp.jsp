<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.sql.*" %>
	<% Class.forName("com.mysql.jdbc.Driver"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wpj","root","cdac");

		PreparedStatement st = conn.prepareStatement("select * from DBCServlet");
	
		ResultSet results = st.executeQuery();
	%>
	
	<TABLE border = "1">
	<TR>
	<TH>id</TH>
	<TH>Username</TH>
	<TH>Password</TH>
	</TR>
	<% while(results.next()){ %>
	
	<tr>
		<td><%= results.getString(1) %></td>
		<td><%= results.getString(2) %></td>
		<td><%= results.getString(3) %></td>
	</tr>
	
	<% } %>
	</TABLE>
</body>
</html>






<%-- 

id	Username	Password
1	Aniket		Kale
2	Sanket		Kale

 --%>


