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

	<link rel="stylesheet" href="css/styles.css">

<title>Shopping List</title>

</head>

<body>

<%-- ----------------------------- Top container, Title Bar and Add Button ------------------------ --%>

<%-- Title Bar --%>
<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-sm-6  bg-primary">
			<div class="row justify-content-center">
				
				<h1>Your Shopping List</h1>
	
			</div>
		</div>
	</div>
</div>

<br><br>

<div class="col-xs-1 " align="center">

	<%-- Add NEW item Button --%>
	<div class="col-sm-5">
	
		<div class="row justify-content-center">
			<form method="GET" action="add.do">
				<input class="btn btn-primary" type="submit" value="Add NEW item">
			</form>
		</div>
		
		<br><br>
		
		<form method="GET" action="getItemByKeyword.do">
			<div class="row justify-content-center">
       			<input type="text" value="${kw}" name="keyword" class="bg-light" min="1" required="required" placeholder="Enter an item" />
       			<input type="submit" value="Find Item by Keyword" class="btn btn-secondary" />
			</div>
   		</form>
   		
   		<br>
   		
   		<form method="GET" action="home.do">
			<div class="row justify-content-center">
       			<input type="submit" value="Reset Page" class="btn btn-warning" />
			</div>
   		</form>

	</div>

	<br> <br> <br>

<%-- ---------------------- Outer container, around buttons --------------------- --%>

	<%-- --- ForEach Loop for buttons --- --%>
	<c:forEach var="list" items="${list }">

		<%--(All Buttons) creates row for each button--%>
		<div class="row justify-content-center">

			<%-- View Info Button --%>
			<div class="col-sm-4">

				<form method="POST" action="info.do?id=${list.id }">
					<input class="btn btn-info btn-block" type="submit"
						value="View ${list.listItem }"> <input type="hidden"
						name="id" value="${list.id }">
				</form>
				
			</div>

			<%-- Update Button --%>
			<div class="col-sm-2">

				<form method="POST" action="update.do?id=${list.id }">
					<input class="btn btn-success btn-block" type="submit"
						value="update"> <input type="hidden" name="id"
						value="${list.id }">
				</form>

			</div>

			<%-- Delete Button --%>
			<div class="col-sm-2">

				<form method="POST" action="delete.do?id=${list.id }">
					<input class="btn btn-danger" type="submit" value="delete">
					<input type="hidden" name="id" value="${list.id }">
				</form>

			</div>

		</div>
		
		<br>	<br>
		
	</c:forEach>
	
</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>