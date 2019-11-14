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

if(session.getAttribute("adminusername")==null)
{
	response.sendRedirect("../login.jsp");
}

%>
<a href="../LogoutSer">Logout</a>
<h1>Welcome in Admin Dashboard</h1>
</body>
</html>