<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP (java code within HTML document)</h2>

	<h1>Hello Aniket..!!!</h1>
	
	<% String str = "Hii Aniket..!!!"; %>
	
	<h1><%= str %></h1>
	
	<h1><%= str +" How are you..??"%></h1>
	
	<div style="text-align : center">
		<%
			for(int i = 1; i <= 7 ; i++){
		%>
			<font size="<%=i%>"> Hello </font> <br>
		<%
			}
		%>
	</div>
</body>
</html>