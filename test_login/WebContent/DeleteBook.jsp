<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.http.*"%>    
<% 
HttpSession ses=request.getSession();
if(ses.getAttribute("id")==null)
 {
	response.sendRedirect("Login.jsp");
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Home.css">
<link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&display=swap" rel="stylesheet">
</head>
<body>
<form action="Logout" method="post">
<div class="sidebar1">
        <ul>
            <li><a href="Delete.jsp"><i class="fas fa-qrcode">Home</i></a></li>
            <li><a href="Add.jsp"><i class="fas fa-qrcode">Add-new User</i></a></li>
            <li><a href="Delete.jsp"><i class="fas fa-qrcode">Delete Existing User</i></a></li>
            <li><a href="AddBook.jsp"><i class="fas fa-qrcode">Add New Book</i></a></li>
            <li><a href="DeleteBook.jsp"><i class="fas fa-qrcode">Delete Existing Book</i></a></li>
            <li><input type="submit" id="login" class="fas fa-qrcode" value="Logout"></li>
        </ul>
    </div>
    
    <section class="content">
            <div id="sectionContent">
                <div class='row'>
                   <div class='column'>
                     <div class='col1 '>
                        <div class="col1row">
                    <h1>DELETE BOOK PAGE</h1>
                    
                    <hr class="border">
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
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr bgcolor="#23463f">
<td><label><b>Book ID</b></label></td>
<td><label><b>Book Name</b></label></td>
<td><label><b>Author</b></label></td>
<td><label><b>Subject</b></label></td>
<td><label><b>Book</b></label></td>
<td><label><b>Action</b></label></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sqlhod ="SELECT * FROM bookf ORDER BY subject;";

resultSet = statement.executeQuery(sqlhod);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getString("bookid") %></td>
<td><%=resultSet.getString("bookname") %></td>
<td><%=resultSet.getString("auth") %></td>
<% 
if("pis".equals(resultSet.getString("subject")))
{
%>
  <td>Principle Of Information Security</td>
<%}
if("ntc".equals(resultSet.getString("subject")))
{
%>
  <td>Number Theory and Cryptography</td>
<%}
if("algo".equals(resultSet.getString("subject")))
{
%>
  <td>Algorithms and Data-structures</td>
<%}
if("math".equals(resultSet.getString("subject")))
{
%>
  <td>Engineering Mathematics</td>
<%}%>
<td><a href="book/<%=resultSet.getString("book") %>"><%=resultSet.getString("book") %></a></td>
<td style="color:#6abadeba"><a href="Bdelete.jsp?d=<%=resultSet.getString("bookid") %>">DELETE</a></td>
</tr>
<%}
}catch (Exception e) {System.out.println(e);}
%>

</table>
</div>
</div>
</div>
</div>
</div>
</section>
</form>
</body>
</html>