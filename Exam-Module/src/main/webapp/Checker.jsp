<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checker</title>
</head>
<body>
	<%	
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("id")==null){
			response.sendRedirect("Home.jsp");
		}
	%>
	<h1>Hello ${name} </h1>
	<form action="Logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>