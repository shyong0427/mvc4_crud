<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
<%@ include file="logincheck.jsp" %>
	** 사용자 수정 **<br>
	<form name="f" method="post">
		아 이 디 : ${user.userid }
	</form>

</body>
</html>