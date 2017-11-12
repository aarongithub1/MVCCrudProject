<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping List</title>
</head>
<body>

<h1>Shopping List</h1>

<%-- <form:form action="getListItem.do" method="post" modelAttribute="idForm">
	<form:input path="id" /><form:errors path="id" />
	<input type="submit" value="Get a list item">
</form:form>
 --%>

<p>
All items in your shopping list: <br>
<c:forEach var="list" items="${list }">
<a href="info.do?id=${list.id }">${list.listItem }</a>

<form method="post" action="delete.do">
<input type="submit" value="delete" >
<input type="hidden" name="id" value="${list.id }">
</form>
<br>

<form method="post" action="update.do">
<input type="submit" value="update" >
<input type="hidden" name="id" value="${list.id }">
</form>

ID: ${list.id }  Name: ${list.listItem } <br>
</c:forEach>

</p>


<%--
<c:if test="${not empty bestGiraffe }">
	The best giraffe is ${bestGiraffe }
</c:if>


 --%>

<p>
<a href="add.do">Add an Item</a>
</p>


<%-- <form action="getListItem.do" method="post">
	<input type="text" name="listId">
	<input type="submit" value="Get an item form the list">
</form> --%>
<!-- <form action="getAllItems.do" method="post">
	<input type="submit" value="Get a list">
</form> -->

<h2>${listItem }</h2>

<%-- <c:if test="${not empty shoppingList }">
<h5>All Items in the list:</h5><br>
<c:forEach var="item" items="${shoppingList }">
<div class="seenItem">${item }</div>
</c:forEach>
</c:if> --%>

<%-- <c:if test="${not empty namesList }">
<h5>Names you've seen:</h5><br>
<c:forEach var="name" items="${namesList }">
<div class="seenName">${name }</div>
</c:forEach>
</c:if> --%>

</body>
</html>