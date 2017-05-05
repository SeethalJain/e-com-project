<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<h2>Manage Category</h2>


<div id="CreateCategory">

<form action = "manage_category_add">

<input type="text" name="id">ID
<input type="text" name="name">NAME
<input type="text" name="cat_type">DESCRIPTION
<input type="Submit" value="Create Category">
</form>
</div>


<div id="UpdateCategory">

<form action = "manage_category_update">

<input type="text" name="id" value="${selectedCategory.id}">ID
<input type="text" name="name" value="${selectedCategory.name}">NAME
<input type="text" name="cat_type" value="${selectedCategory.cat_type}">DESCRIPTION
<input type="Submit" value="Update Category">
</form>
</div>




  	<h2> Delete / Update the Categories  </h2>
	<div id = "ShowCategory">								//to get category list in manage category  for admin
	
	<table>
		<thead border="2">
		<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Action</td>
	    </tr>
		</thead>
	
	<c:forEach var="category" items="${categoryList}">
	
	<tr>
	  <td>${category.id}</td>
	  <td>${category.name}</td>
	  <td>${category.cat_type}</td>
	  
	  <td> <a href="manage_category_delete/${category.id}">Delete</a>
	   <a href="manage_category_edit/${category.id}">Edit</a></td>
	</tr>
	
	</c:forEach>
	</table>
	</div>
</body>
</html>