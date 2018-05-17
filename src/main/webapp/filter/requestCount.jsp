<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<!-- localhost:8070/jsp/filter/requestCount.jsp	 -->

	
<%
/*
	Map<String, Integer> counterMap = (Map<String, Integer>)application.getAttribute("counterMap");

	Set<String> keySet = counterMap.keySet();
	Iterator<String> iterator = keySet.iterator();
	
	while(iterator.hasNext()){
		String key = iterator.next();
		out.print("key : " + key + " : " + counterMap.get(key) + "<br>");
	}
*/

%>

<c:forEach items="${counterMap }" var="cm">
	${cm.key } : ${cm.value }<br>
</c:forEach>

<%
	
%>	
	
</body>
</html>