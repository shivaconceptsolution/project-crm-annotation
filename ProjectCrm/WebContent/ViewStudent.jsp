<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="org.hibernate.*" %>  
 <%@page import="org.hibernate.cfg.*" %> 
 <%@page import="java.util.*" %>  
 <%@page import="dao.Student" %>
  <%@page import="dao.HiberHelper" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>Rno</th><th>Sname</th><th>Branch</th><th>Fees</th><th colspan="2">Operation</th></tr>
<%
HiberHelper.configure();
Query q =HiberHelper.dqlOperation("from Student s");
List<Student> lst= q.list();
Iterator it = lst.iterator();
while(it.hasNext())
{
	Student stu = (Student)it.next(); %>
	<tr><td><%= stu.getRno() %> </td><td><%= stu.getSname() %></td><td><%= stu.getBranch() %></td><td><%= stu.getFees() %></td>
	<td><a href="EditStudent.jsp?q=<%= stu.getRno()  %>"> Edit</a></td><td><a href="DeleteStudent.jsp?q=<%= stu.getRno()  %>">Delete</a></td>
	
	</tr>
	
	
<%}

HiberHelper.closeConn();

%>
</table>
</body>
</html>