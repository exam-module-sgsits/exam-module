<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%	
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("id")==null){
			response.sendRedirect("Home.jsp");
		}
	%>
	<h1>Hello ${name} with id ${id} </h1>
	<form action="Logout" method="post">
        <input type="submit" value="Logout">
    </form>
    <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/first_database" user="root" password=""/>
	<sql:query var="rs" dataSource="${db}">SELECT * from students</sql:query>
	<c:forEach items="${rs.rows}" var="student">
		<br>
		<c:out value="${student.name}"></c:out>
	</c:forEach>
</body>
</html>