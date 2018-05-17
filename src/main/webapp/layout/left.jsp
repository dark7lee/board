<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">게시판 목록 <span class="sr-only">(current)</span></a></li>
		
		<c:forEach items="${boardList }" var="TboardVO">
			<li class="TboardVO"><a href="${pageContext.request.contextPath}/boadDetail?tboard_seq=${TboardVO.tboard_seq }&page=1&pageSize=10">${TboardVO.tboard_title }</a></li>
		</c:forEach>
	</ul>
</div>