<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<h2>링크 테스트</h2>

<!-- /test/ 는 가상 디렉토리임-->
<a href="${path }/test/doA">doA</a>
<a href="${path }/test/doB">doB</a>
<a href="${path }/test/doC">doC</a>
<a href="${path }/test/doD">doD</a>
<a href="#" onclick="doF()">doF</a>
<div id="result"></div>

</body>
</html>