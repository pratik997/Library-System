<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="AddUser" method="post">
<div class="sidebar">
        <ul>
            <li><a href="Delete.jsp"><i class="fas fa-qrcode">Home</i></a></li>
            <li><a href="Add.jsp"><i class="fas fa-qrcode">Add-new User</i></a></li>
            <li><a href="Delete.jsp"><i class="fas fa-qrcode">Delete Existing User</i></a></li>
            <li><a href="AddBook.jsp"><i class="fas fa-qrcode">Add New Book</i></a></li>
            <li><a href="DeleteBook.jsp"><i class="fas fa-qrcode">Delete Existing Book</i></a></li>
        </ul>
    </div>
   
    <section class="content">
            <div id="sectionContent">
                <div class='row'>
                   <div class='column'>
                    <h1>ADD NEW USER PAGE</h1><br><br>
<div class="login">
<h3>${ message}</h3>
<label><b>Login Id</b></label><br><input type="text" name="id" id="id"><br><br>
<label><b>Password</b></label><br><input type="password" name="pass" id="id"><br><br>
<label><b>User Name</b></label><br><input type="text" name="un" id="id"><br><br>
<label><b>Role</b></label><br><input type="text" name="ro" id="id"><br><br>
<input type="submit" name="submit" id="login"><br><br>
</div>
</div>
</div>
</div>
</section>
</form>
<script src='action.js' type='text/javascript'></script>
</body>
</html>