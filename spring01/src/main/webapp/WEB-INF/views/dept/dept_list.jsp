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
<h2>부서목록</h2>
<table>
  <tr>
    <th>부서번호</th>
    <th>부서이름</th>
    <th>부서위치</th>
  </tr>
  <c:forEach var = "row" items="${list}">
  <tr>
    <td>${row.deptno} </td>
    <td>${row.dname}</td>
     <td>${row.loc}</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>