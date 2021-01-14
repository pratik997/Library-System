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
                    <h1>WELCOME TO ONLINE LIBRARY</h1>
                    
                    <hr class="border">
                    <br><br>
                    <p>Welcome to our Online Library, here you are free to read any book of various subjects available here. Choose the subject form side navigation and then choose the book, and you can read it, IT's THAT EASY!!<p>
                    </div>
                    </div>
                    </div>
                    </div>
                    </div>
                    </section>
</form>
</body>
</html>