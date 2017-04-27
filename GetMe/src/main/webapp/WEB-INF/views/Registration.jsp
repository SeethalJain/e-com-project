<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body><CENTER>

FIRST_NAME:<input type ="text" name="firstname"><br>
LAST_NAME<input type ="text" name="lastname"><br>
EMAIL_ID<input type ="text" name="emailid"><br>
GENDER:<input type="text" name="gender"><br>
DOB:<input type ="text" name="dob"><br>
ADDRESS:<input type ="text" name="address"><br>
CITY:<input type ="text" name="city"><br>
STATE:<input type ="text" name="state"><br>
COUNTRY:
<div class="container">                                       
  <div class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown">
    Country<span class="caret"></span></a>
    <ul class="dropdown-menu">
      <li><a href="#">INDIA</a></li>
      <li><a href="#">SRILANKA</a></li>
      <li><a href="#">PAKISTAN</a></li>
    </ul>
  </div>
</div>

<input type="submit" value="REGISTER">
</CENTER>
</body>
</html>
