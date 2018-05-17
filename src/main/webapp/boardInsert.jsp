<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	  rel="stylesheet">
<%@ include file="/include/commonCss.jsp" %>
<%@ include file="/include/jquery.jsp" %>

<script>
$(function(){
	
	//화면 로딩 시 제목 입력칸에 focus
	$('#tboard_title').focus();
		
	//게시글 등록 버튼
	$("#tBoardReg").on("click", function(){
		
		//validation
		if($('#tboard_title').val().trim() == ""){
			alert("게시글명이 입력되지 않았습니다.");
			$('#tboard_title').focus();
			return false;
		}
		
		//submit
		$("#frm").submit();
	
	})
})
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
	<%@ include file="/layout/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="frm" action="${pageContext.request.contextPath }/boardInsert" method="post" 
				      class="form-horizontal" role="form">

					<div class="form-group">
						<label for="boardNm" class="col-sm-2 control-label">게시판명</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="tboard_title" name="tboard_title">
							<input type="hidden"  id="hidden_title" name="hidden_title">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="tBoardReg" type=button class="btn btn-default">등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>