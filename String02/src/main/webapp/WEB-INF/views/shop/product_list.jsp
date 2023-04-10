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
<h2>상품 목록</h2>
<table border="1" style="width: 100%;">
  <tr>
    <th>상품 코드</th>
    <th>&nbsp;</th>
     <th>상품명</th>
    <th>가격</th>
  </tr>
  <c:forEach var="row" items="${list}">
  <tr>
    <td>${row.product_id }</td>
    <td><img src="${path }/images/${row.picture_url}" width="100px" height="100px"> </td>
    <!-- 상세 화면 페이지 이동 -->
    <td><a href="${path }/shop/product/detail/${row.product_id}">${row.product_name }</a></td>
    <td><fmt:formatNumber  value="${row.price }" pattern="#,###"/> </td>
  </tr>
  </c:forEach>
</table>
</body>
</html>