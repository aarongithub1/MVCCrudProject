<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
    						integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" 
    						crossorigin="anonymous">

<title>Shopping List</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

<p>

<!-- <span class="border border-success"></span> -->

<div class="container-fluid">
	
	<div class="row justify-content-center">
	
	<span class="border rounded border-primary ">
		<h1>Shopping List</h1>
	</span>
	
	</div>
	
	<div class="row justify-content-center">
		All items in your shopping list: <br>
	</div>
	
	<div class="row justify-content-center">
		<form method="get" action="add.do">
		<input type="submit" value="add">
		</form>
	</div>
	<br>
	<br>
	<br>
	
</div>

<c:forEach var="list" items="${list }">
<div class="container-fluid">
		
		<%--All Buttons --%>
        <div class="row">
        		
		
        		<div class="col-sm-4">
				<%-- <a href="info.do?id=${list.id }">${list.listItem }</a> --%>
				<form method="post" action="info.do?id=${list.id }">
				<input class="btn btn-primary btn-block" type="submit" value="Add ${list.listItem }">
				<input type="hidden" name="id" value="${list.id }">
				</form>
        		</div>
        		
        		<div class="col-sm-2 justify-content-center">
				<%-- <input type="submit" value="update" > --%>
				
				<%-- Update Button --%>
				<form method="post" action="update.do">
				<input class="btn btn-success" type="submit" value="update">
				<input type="hidden" name="id" value="${list.id }">
				</form>
				
        		</div>
        		
        		<div class="col-sm-1">
        			<%-- <a class="btn btn-primary" href="delete.do?id=${list.id }" role="button">Link to delete</a> --%>
				<%-- <input type="submit" value="delete" > --%>
				
				<%-- Delete Button --%>
				<form method="post" action="delete.do">
				<input class="btn btn-danger" type="submit" value="delete">
				<input type="hidden" name="id" value="${list.id }">
				</form>
				
        		</div>
			
        </div> 
        
</div>

<br>
<br>

<%-- ${list.id } ${list.listItem } <br> --%>

</c:forEach>


</p>


	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>
<!-- <p>
<a href="add.do">Add an Item</a>
</p> -->
<%-- <input type="hidden" name="id" value="${list.id }"> --%>