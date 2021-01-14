<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.*"%>
<% 
HttpSession ses=request.getSession();
if(ses.getAttribute("id")==null)
 {
	response.sendRedirect("Login.jsp");
 }
%>
<%
String id = request.getParameter("name");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/test";
String userId = "root";
String password = "root123";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet" type="text/css" href="Home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Logout" method="post">
<div class="sidebar1">
        <ul>
            <li><a href="User.jsp"><i class="fas fa-qrcode">Home</i></a></li>
            <li><a href="Algo.jsp"><i class="fas fa-qrcode">Algorithm and Data Structures</i></a></li>
            <li><a href="Math.jsp"><i class="fas fa-qrcode">Engineering Mathematics</i></a></li>
            <li><a href="NTC.jsp"><i class="fas fa-qrcode">Number Theory and Cryptography</i></a></li>
            <li><a href="PIS.jsp"><i class="fas fa-qrcode">Principles of Information Security</i></a></li>
            <li><input type="submit" id="login" class="fas fa-qrcode" value="Logout"></li>
        </ul>
    </div>
    
    
    <section class="content">
            <div id="sectionContent">
                <div class='row'>
                   <div class='column'>
                     <div class='col1 '>
                        <div class="col1row">
                    <h1>NUMBER THEORY AND CRYPTOGRAPHY</h1>
                    <hr class="border">
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sqlhod ="SELECT * FROM bookf WHERE subject='ntc';";

resultSet = statement.executeQuery(sqlhod);
while(resultSet.next()){
%>
<ul>
<li><u><b>Book:</b></u>&nbsp;&nbsp; <%=resultSet.getString("bookname") %><br>
    <u><b>Author Name:</b></u>&nbsp;&nbsp; <%=resultSet.getString("bookname") %><br>
    Click Here To View: &nbsp;&nbsp;<a href="book/<%=resultSet.getString("book") %>"><%=resultSet.getString("book") %></a>
</li>
</ul>
<br><br><br>
<%}
}catch (Exception e) {System.out.println(e);}
%>
<br><br><br><br><br><br><br><br>
</div>
</div>
</div>
</div>
</div>
</section>
</form>
</body>
</html>