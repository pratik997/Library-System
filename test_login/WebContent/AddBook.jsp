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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Home.css">
<link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&display=swap" rel="stylesheet">
</head>
<body>
<form action="AddBook" method="post" enctype="multipart/form-data">
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
                    <h1>ADD NEW BOOK PAGE</h1><br><br>
<div class="login">
${message}<br>
<label><b>Book ID</b></label><br><input type="text" name="bid" id="id"><br><br>
<label><b>Book Name</b></label><br><input type="text" name="bname" id="id"><br><br>
<label><b>Author Name</b></label><br><input type="text" name="name" id="id"><br><br>
<label><b>Subject</b></label><br>
<select id="sub" name="sub">
        <option selected>-Choose Faculty-</option>
        <option value="pis">Principle Of Information Security</option>
        <option value="ntc">Number Theory and Cryptography</option>
        <option value="algo">Algorithms and Data-structures</option>
        <option value="math">Engineering Mathematics</option>
    </select><br><br>
<label><b>Book-PDF</b></label><br><input type="file" name="pdf" id="id"><br><br>

<input type="submit" name="submit" id="login">
</div>
</div>
</div>
</div>
</section>
</form>
</body>
</html>