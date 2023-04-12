<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- 구글 차트 호출을 위한 js파일 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
/* 구글 차트 라이브러리 로딩 */
 google.charts.load('current', {'packages':['corechart']});
/* 라이브러리 로딩이 완료되면 drawChart 함수 호출 , 주의 : ()는 안씀 */
 google.charts.setOnLoadCallback(drawChart);

 function drawChart() {
	/* 차트 그리기에 필요한 json 데이터 로딩 */
	var jsonData = $.ajax({
		url:"${path}/json/sampleData.json",
		dataType:"json",
		async:false /* 동기식 처리(순차적처리: 데이터를 다 부른 후 차트 출력하기 위해) */
		
	}).responseText;
	console.log(jsonData);
	var data=new google.visualization.DataTable(jsonData);
	console.log("데이터 테이블 : " + data);
	var option={titile: '차트 예제', is3D: true}  /* 2d는 false하거나 없앰 */
	var chart = new google.visualization.PieChart(document.getElementById("chart_div"));
 	chart.draw(data, options);
 }

</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<div id="chart_div" style="width: 600px; height: 440px;"></div>
<button id="btn" type="button" onclick="drawChart()">refresh</button>


</body>
</html>