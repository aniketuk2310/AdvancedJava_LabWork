<%@page import="OnlineExamApp.Option"%>
<%@page import="java.util.List"%>
<%@page import="OnlineExamApp.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="QuestionLoaderServlet"> -->
<form action="CalculateScoreServlet">
	<%
		Question question = (Question) session.getAttribute("currQue");
	%>
	
	<h1>Q. <%= question.getQuestion() %></h1>
	
	<%
		List <Option> options = question.getOptions();
		for(int i=0; i<options.size(); i++){
			Option option = options.get(i);		
	%>	
			<div>
			<input type="radio" name="op" value="<%= i %>">
				<%= option.getOption() %>
			</div>	
	<% 
		} 
	%>
	
	<!--	<a href="QuestionLoaderServlet">Next</a>	// we have to run servlet to go to the next question everytime. -->

	<br>
	<button type="submit">Next</button>
	
</form>
	
</body>
</html>