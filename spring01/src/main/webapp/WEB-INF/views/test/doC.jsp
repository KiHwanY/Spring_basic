<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>doC 페이지</h2>
<h2>
<!-- name과 price 는 각 getter 로 값을 가져오는 것임. -->
상품명 : ${map.product.name } <br>
가격 : ${map.product.price } 
</h2>
</body>
</html>