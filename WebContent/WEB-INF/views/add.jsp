<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter an item</title>
</head>
<body>

<h3>Enter data in the item fields:</h3>

<form:form action="addItem.do" method="post" modelAttribute="list">
	
	Item: <form:input path="listItem"/>  <form:errors path="listItem"/>                        <br>
	Number of Items: <form:input path="numberOfItems"/>  <form:errors path="numberOfItems"/>   <br>
	Item Price: <form:input path="itemPrice"/>  <form:errors path="itemPrice"/>           <br>
	
	
	add a URL input!!
	<%-- Image URL: <form:input path="imgUrl"/>  <form:errors path="imgUrl"/>            <br> --%>
	<input type="submit" value="Add item to list">
	
</form:form>

</body>
</html>