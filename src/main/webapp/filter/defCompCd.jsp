<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/DefCompCdServlet" method="post">
	<input type="text" name="userId" value="brown"><br>
	<input type="text" name="unt_cd" value=""><br>
	<input type="submit" value="전송"><br>
</form>

</body>
</html>