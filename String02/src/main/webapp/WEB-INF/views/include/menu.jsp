<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="path" value="${pageContext.request.contextPath }"/>   

<div style="text-align: center;">
 	<a href="${path }">Home</a> |
	<a href="${path}/memo/list.do">메모장</a> |
	<a href="${path}/upload/uploadForm">업로드 테스트</a> |
	<a href="${path}/shop/product/list.do">상품 목록</a> |
	<div style="text-align: right;">
	<a href="${path}/member/login.do">로그인</a> |
	</div>
</div>
<hr>