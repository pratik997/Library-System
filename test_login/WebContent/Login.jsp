<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Login.css"> 
</head>
<body>
<div class="login">
<form action="LoginRegister" method="post">
${message}
<label><b>Login Id</b></label><br>
<input type="text" name="id" id="id"><br><br>
<label><b>Password</b></label><br>
<input type="password" name="pass" id="pass"><br><br>
<input type="submit" name="login" id="login" value="Login">
</form>
</div>
</body>
</html>