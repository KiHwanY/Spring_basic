<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="path" value="${pageContext.request.contextPath }"/>   

<div style="text-align: center;">
 	<a href="${path }/">main</a>
	<a href="${path }/gugu.do">구구단</a>
	<a href="${path }/test.do">테스트</a>
	<a href="${path }/member/list.do">회원관리</a>
	<a href="${path }/dept/list.do">부서관리</a>
</div>
<hr>