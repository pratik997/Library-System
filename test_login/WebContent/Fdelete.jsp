<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<% 
HttpSession ses=request.getSession();
if(ses.getAttribute("id")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<%
String id=request.getParameter("d");
System.out.println(id);
Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
Statement smt=cn.createStatement();
smt.executeUpdate("delete from login where loginid='"+id+"'");
response.sendRedirect("Delete.jsp");
%>
