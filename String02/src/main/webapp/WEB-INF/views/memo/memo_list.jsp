<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
function memo_view(idx) {
	location.href="${path}/memo/view/" + idx;
	/* REST(Representational state transfer ) 방식, 또는 RESTful 한 URI 방식 */
	/* 게시물로 고유한 주소값을 가짐, 게시물 하나가 주소 1개이다.  */ㄴ
	/*  따라서 이런 방식에서는 스프링에서 @PathVariable 을 적용 */
}

</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>메모장</h2>
<form action="${path }/memo/insert.do"></form>
이름 :  <input name="writer" size="10">
메모 : <input id ="memo" name="memo" size="40">
	<input type="submit" value="확인">
<table>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>메모</th>
    <th>날짜</th>
  </tr>
  <c:forEach var ="row" items="${list }">
  <tr>
    <td>${row.idx }</td>
    <td>${row.writer }</td>
      <td><a href="#" onclick="memo_view('${row.idx}')"> ${row.memo } </a></td>
    <td><fmt:formatDate value="${row.post_date }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
  </tr>
  </c:forEach>
</table>




</body>
</html>