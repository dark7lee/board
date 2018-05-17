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
<%@ include file="/include/commonCss.jsp"%>
<%@ include file="/include/jquery.jsp"%>
<script>
	$(function() {

		//게시판 정보 수정 클릭 이벤트
		$('#modifyBoard').click(
				function() {
					//method : get : 조회할 때, post : 서버 상에 변경이 일어날 때 //그래서 여기는 get : 여기서 바로 수정은 아니고 여기서는 화면전환이라
					//action : /modifyUser
					$('#frm').attr('action',
							'${pageContext.request.contextPath }/boardModify');
					$('#frm').attr('method', 'get');
					$('#frm').submit();
				})

		//게시판 정보 삭제버튼 클릭 이벤트
		$('#deleteBoard').click(
				function() {
					//method : get : 조회할 때, post : 서버 상에 변경이 일어날 때 //그래서 여기는 post
					//action : /deleteUser
					$('#frm').attr('action',
							'${pageContext.request.contextPath }/boardDelete');
					$('#frm').attr('method', 'post');
					$('#frm').submit();
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

			${boardVO}
			${fileVO}
				
				<form id="frm" class="form-horizontal" role="form">
					<input type="hidden" name="board_tboard_seq" id="board_tboard_seq" value="${boardVO.board_tboard_seq }">

					<div class="form-group">
						<label for="boardNm" class="col-sm-2 control-label">게시글명</label>
						<div class="col-sm-3">
							<label class="control-label">${boardVO.board_title }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="boardNm" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-3">
							<textarea rows="20" cols="50">${boardVO.board_content }</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label for="boardNm" class="col-sm-2 control-label">파일 업로드</label>
						<div class="col-sm-3">
							<img src="${pageContext.request.contextPath }/${fileVO.file_path }" width="150" height="150">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="modifyBoard" type="button" class="btn btn-default">수정</button>
							<button id="deleteBoard" type="button" class="btn btn-default">삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

