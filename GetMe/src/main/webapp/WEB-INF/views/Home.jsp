
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
</head>
<body>


<center><h1>GetMe</h1>
<h3>Grab ME...AM Yours..:):)</h3></center>
${msg}
<div-class="row">
   <div-class="col-md-4">

<jsp:include page="Menu.jsp"></jsp:include>

<c:if test = "${isAdmin=='true'}">
	<jsp:include page="Admin/AdminHome.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedCategory=='true'}">
<jsp:include page="Admin/Category.jsp"></jsp:include>
</c:if>	

<c:if test="${isAdminClickedSupplier=='true'}">
<jsp:include page="Admin/Supplier.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedProduct=='true'}">
<jsp:include page="Admin/Product.jsp"></jsp:include>
</c:if>


<c:if test="${isValidLogin == 'true'}">
<jsp:include page= "Login.jsp"></jsp:include>
</c:if>
<a href = "Login">Login</a>
</div-class>
<div-class="col-md-4">
<c:if test="${isValidRegister == 'true'}">
<jsp:include page= "Registration.jsp"></jsp:include>
</c:if>
<a href = "Registration">Register</a>
</div-class>

</body>
</html>