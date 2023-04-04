<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:set var="path" value="${pageContext.request.contextPath }"/>   

<div style="text-align: center;">
 	<a href="${path }">Home</a> |
	<a href="${path}/memo/list.do">메모장</a> |
	
</div>
<hr>