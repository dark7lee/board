<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap/css/dashboard.css" rel="stylesheet">
<%@ include file="/include/commonCss.jsp" %>
<%@ include file="/include/jquery.jsp" %>

<script>
	$(function(){
		
		//게시판 상세정보 보이기 이벤트
		//tr 태그 click 이벤트 처리
		$("#boardList tr").on("click", function(){
			var tboard_seq = $(this).find("td:eq(0)").text();
			$("#tboard_seq").val(tboard_seq);
			$("#frm").submit();
		})
		
		//게시판 등록 버튼 이벤트
		$('#boardReg').on("click", function(){
			document.location = "${pageContext.request.contextPath }/boardInsert.jsp"
		})
		
		//게시판 활성or비활성
		
		
	})
</script>

  </head>

  <body>
	<%@ include file="/layout/header.jsp" %>
    
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
    
	<form id="frm" method="get" action="${pageContext.request.contextPath }/boadDetail">
		<input type="hidden" name="tboard_seq" id="tboard_seq">
	</form>        
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">게시판 관리화면</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>NO.</th>
                  <th>게시판명</th>
                  <th>글쓴일자</th>
                  <th>글쓴이</th>
                </tr>
              </thead>
              <tbody id="boardList">
                 <c:forEach items="${boardList }" var="TboardVO">
				 	<tr>
					   <td>${TboardVO.tboard_seq }</td>
					   <td>${TboardVO.tboard_title }</td>
					   <td><f:formatDate value="${TboardVO.tboard_reg_dt }" pattern="yyyy-MM-dd"/></td>
					   <td>${TboardVO.tboard_mem_id }</td>
				 	</tr>
			     </c:forEach>
              </tbody>
            </table>
          </div>
         <button id="boardReg" type="button" class="btn btn-default">게시판 등록</button>
         <button id="boardAtive" type="button" class="btn btn-default">게시판 활성</button>
         
		<!-- 페이지 네비 만들기 -->
         
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
