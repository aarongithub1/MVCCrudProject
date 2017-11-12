<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
<title>Add item</title>

</head>

<%---------------- Title Bar ----------------%>
<body>
<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-sm-6 bg-warning">
			<div class="row justify-content-center">
			
				<h1>Enter data in the item fields:</h1>
	
			</div>
		</div>
	</div>
</div>

<br><br>

<%---------------- input fields and ADD button ----------------%>
<div class="col-xs-1 " align="center">

<form:form action="addItem.do" method="post" modelAttribute="shoppingList">
	
	<div class="row justify-content-center">
		<div class="col-4">
			<form:input path="listItem" class="form-control form-control-lg" type="text" placeholder="Enter an item"/><form:errors path="listItem"/>
		</div>
	</div>
	
	<div class="row justify-content-center">
		<div class="col-4">
			<form:input path="numberOfItems" class="form-control form-control-lg" type="text" placeholder="Enter number of item"/><form:errors path="numberOfItems"/>
		</div>
	</div>
	
	<div class="row justify-content-center">
		<div class="col-4">
			<form:input path="itemPrice" class="form-control form-control-lg" type="text" placeholder="Enter item price"/><form:errors path="itemPrice"/>
		</div>
	</div>
	
	<br>	<br>	
	
	<%--------- submit button ---------%>
	<input type="submit" class="btn btn-primary" value="Add item to list">
	
</form:form>

</div>

</body>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>


</html>