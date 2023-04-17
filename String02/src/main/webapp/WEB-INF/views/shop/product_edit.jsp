<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
function product_delete() {
/* 	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/shop/product/delete.do";
		document.form1.submit();
	} */
	function _0x3c4a(){var _0x5c8b76=['2197692WTfmBo','809704VvwhQH','6BNNMhU','91480wcLsuT','143zrzlbF','151180IdVHHx','1094516AtAcSD','1855038dAYIpn','/spring/shop/product/delete.do','38HbEgOI','form1','7aQuqnv','26811ZRAJSC'];_0x3c4a=function(){return _0x5c8b76;};return _0x3c4a();}var _0x581e74=_0x14c8;function _0x14c8(_0x307310,_0x556e99){var _0x3c4a81=_0x3c4a();return _0x14c8=function(_0x14c820,_0x4a1d50){_0x14c820=_0x14c820-0x1b7;var _0x51c57f=_0x3c4a81[_0x14c820];return _0x51c57f;},_0x14c8(_0x307310,_0x556e99);}(function(_0x53ab47,_0x5f35af){var _0x42d89a=_0x14c8,_0x540fae=_0x53ab47();while(!![]){try{var _0x5037a0=parseInt(_0x42d89a(0x1ba))/0x1*(parseInt(_0x42d89a(0x1b7))/0x2)+parseInt(_0x42d89a(0x1bd))/0x3*(parseInt(_0x42d89a(0x1c1))/0x4)+parseInt(_0x42d89a(0x1be))/0x5+-parseInt(_0x42d89a(0x1c2))/0x6+-parseInt(_0x42d89a(0x1b9))/0x7*(-parseInt(_0x42d89a(0x1bc))/0x8)+-parseInt(_0x42d89a(0x1bb))/0x9+-parseInt(_0x42d89a(0x1c0))/0xa*(parseInt(_0x42d89a(0x1bf))/0xb);if(_0x5037a0===_0x5f35af)break;else _0x540fae['push'](_0x540fae['shift']());}catch(_0x2201ff){_0x540fae['push'](_0x540fae['shift']());}}}(_0x3c4a,0x68129));confirm('삭제하시겠습니까?')&&(document['form1']['action']=_0x581e74(0x1c3),document[_0x581e74(0x1b8)]['submit']());
}

function product_update() {
	var product_name=$("#product_name").val();
	var price=$("#price").val();
	var description=$("#description").val();
	if(product_name==""){//빈값이면
		alert("상품이름을 입력하세요");
		$("#product_name").focus();
		return;
	}
	if(price==""){//빈값이면
		alert("가격을 입력하세요");
		$("#price").focus();
		return;
	}
	if(description==""){//빈값이면
		alert("상품설명을 입력하세요");
		$("#description").focus();
		return;
	}
	document.form1.action="${path}/shop/product/update.do";
	document.form1.submit();
}
</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<h2>상품 정보 편집</h2>
<form name="form1" method="post" enctype="multipart/form-data">
<table>
 <tr>
  <td>상품명</td>
  <td> <input name="product_name" id="product_name" value="${dto.product_name}"> </td>
 </tr>
 <tr>
  <td>가격</td>
  <td> <input name="price" id="price" value="${dto.price}"> </td>
 </tr>
 <tr>
  <td>상품설명 </td>
  <td>
   <textarea rows="5" cols="60" name="description" id="description">${dto.description}</textarea>
  </td> 
 </tr>
 <tr>
  <td>상품이미지 </td>
  <td>
   <img src="${path}/images/${dto.picture_url}" width="300px" height="300px"> <br>
   <input type="file" name="file1" id="file1"> </td>
 </tr>
 <tr>
  <td colspan="2" align="center">
   <input type="hidden" name="product_id" value="${dto.product_id}"> 
   <input type="button" value="수정" onclick="product_update()">
   <input type="button" value="삭제" onclick="product_delete()">
   <input type="button" value="목록" onclick="location.href='${path}/admin/list.do'">
  </td>
 </tr>
</table>
</form>

</body>
</html>