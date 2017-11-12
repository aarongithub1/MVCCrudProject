<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping list info</title>
</head>
<body>

<h2>Shopping list info page</h2>



${shoppingList.listItem }<br>
${shoppingList.numberOfItems }<br>
${shoppingList.itemPrice }<br>
<p>
<c:if test="${shoppingList.id == 1 }">
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
</c:if>

<br>
<br>

<a href="home.do">Home</a>
<!-- <img src="images/dobby.jpg"/> -->

</p>

</body>
</html>