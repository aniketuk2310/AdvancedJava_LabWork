<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			System.out.println("Testing the jsp lifecycle");
		%>
		
		<%!
			public void jspInit(){
				System.out.println("jspInit method called..");
			}
		
			public void jspDestroy(){
				System.out.println("jspDestroy method called...");
			}
		%>
	
</body>
</html>