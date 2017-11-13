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

<title>Info Page</title>

</head>

<body>

<%-- Title Bar --%>
<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-sm-6 bg-info">
			<div class="row justify-content-center">
			
				<h1>Info Page</h1>
	
			</div>
		</div>
	</div>
</div>

<br><br>

<div class="col-xs-1 " align="center">

	<div class="row justify-content-center">
		<h2>Item: "${shoppingList.listItem }"</h2>
	</div>

	<div class="row justify-content-center">
		<h3>Number of items: ${shoppingList.numberOfItems }</h3>
	</div>	

	<div class="row justify-content-center">
		<h3> Price per item: <fmt:formatNumber value="${shoppingList.itemPrice }" type="currency"/></h3>
	</div>
	
	
</div>

<div class="col-xs-1 " align="center">


<br><br>

<p>

<%-- <c:if test="${shoppingList.id == 1 }">
<img src="images/eggs.png"/>
</c:if>
<c:if test="${shoppingList.id == 2 }">
<img src="images/spinach.png"/>
</c:if>
<c:if test="${shoppingList.id == 3 }">
<img src="images/milk.png"/>
</c:if>
<c:if test="${shoppingList.id == 4 }">
<img src="images/hashbrowns.png"/>
</c:if>
<c:if test="${shoppingList.id == 5 }">
<img src="images/bacon.png"/>
</c:if> --%>
<c:if test="${shoppingList.listItem eq 'Eggs' }">
<img src="images/eggs.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Spinach' }">
<img src="images/spinach.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Milk' }">
<img src="images/milk.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Hash browns' }">
<img src="images/hashbrowns.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Bacon' }">
<img src="images/bacon.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Banana' }">
<img src="images/banana.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Durian' }">
<img src="images/durian.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Apple' }">
<img src="images/apple.png"/>
</c:if>
<c:if test="${shoppingList.listItem eq 'Orange' }">
<img src="images/orange.png"/>
</c:if>




<br><br>

<%-- Home page button --%>
<div class="col-3" align="center">
<form method="get" action="home.do">
	<input class="btn btn-lg btn-success btn-block" type="submit" value="Back to home page">
	<input type="hidden" name="id" value="${list.id }">
</form>
</div>

<!-- <a href="home.do">Home</a> -->

</p>

</div>


</body>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</html>