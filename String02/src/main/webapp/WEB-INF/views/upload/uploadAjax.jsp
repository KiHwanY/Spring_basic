<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<style type="text/css">
.fileDrop{
	width: 100%;
	height: 200px;
	border: 1px dotted blue;
}
</style>
<script type="text/javascript">
$(function() {
	/* 드래그 할 때 기본 효과를 막음 */
	$(".fileDrop").on("dragenter dragover" , function(event) {
		event.preventDefault();
	});
	$(".fileDrop").on("drop", function(event) {
		/* drop이 될 때 기본 효과를 막음 */
		event.preventDefault();
		/* 첨부파일 배열(여러개 동시 드래그 시 한개만 처리하도록 조치)  */
		var files = event.originalEvent.dataTransfer.files;
		var file=files[0]; // 첫번째 첨부파일
		var formData = new FormData(); /* Ajava 방식의 파일 업로드의 핵심 객체  */
		formData.append("file",file); /* 폼에 file 변수 추가 */
		//서버에 파일 업로드(백그라운드에서 실행)
		$.ajax({
			type:"post",
			url:"${path}/upload/uploadAjax",
			data : formData,
			dataType: "text",
			processData: false, // 파일 전송시 자동으로 쿼리 스트링 형식으로 전송되지 않도록 막는 처리
			contentType: false, /* multipart/ form-data 로 처리되는 것과 같음*/
			seccess: function(data, status,req) {
				console.log("data: "+ data ); // 업로드된 파일 이름
				console.log("status: "+ status ); // 성공, 실패 여부
				console.log("req: "+ req.status);// 요청 코드값
			}
		});
	});
});



</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>Ajax File Upload</h2>
<!-- 파일을 업로드할 영역 -->
<div class="fileDrop"></div>


<!-- 업로드된 파일 목록을 출력 영역 -->
<div class="uploadedList"></div>

</body>
</html>