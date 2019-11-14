<%@page import="org.hibernate.validator.HibernateValidatorConfiguration"%>
<%@page import="dao.HiberHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="org.hibernate.*" %>  
 <%@page import="org.hibernate.cfg.*" %> 
 <%@page import="java.util.*" %>  
 <%@page import="dao.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome in JSP</h1>
<%
HiberHelper.configure();
Query q = HiberHelper.dqlOperation("from Student s where rno=:a");
q.setInteger("a",Integer.parseInt(request.getParameter("q")));
List<Student> lst= q.list();
Iterator it = lst.iterator();
if(it.hasNext())
{
Student stu =(Student) it.next();	
%>

<form name="frm" action="UpdateSer" method="post">
<input type="text" name="txtrno" value="<%= stu.getRno() %>" placeholder="enter rno" />

<br>
<br>
<input type="text" name="txtsname" value="<%= stu.getSname() %>" placeholder="enter name"/>
<br>
<br>
<input type="text" name="txtbranch" value="<%= stu.getBranch() %>" placeholder="enter branch"/>
<br>
<br>
<input type="text" name="txtfees" value="<%= stu.getFees() %>" placeholder="enter fees"/>
<br>
<br>
<input type="submit" name="btnsubmit" value="Update" />
</form>
<%
}
HiberHelper.closeConn();
%>
</body>
</html>