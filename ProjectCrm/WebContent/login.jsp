<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login Here</h1>
<form action="LoginSer" method="post">
<input type="text" name="txtuser" placeholder="enter username" />
<br>
<br>
<input type="password" name="txtpass" placeholder="enter password" />
<br>
<br>
<select name="ddlrole">
<option value="admin">Administrator</option>
<option value="ProjectManager">Project Manager</option>
<option value="Developer">Developer</option>
</select>
<br>
<br>
<input type="submit" name="btnsubmit" value="Login" />
</form>
<% if(request.getParameter("error")!=null)
	out.print(request.getParameter("error"));
	
	%>
</body>
</html>