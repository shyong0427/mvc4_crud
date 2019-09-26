<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
	<script type="text/javascript">
		window.onload = function() {
			document.getElementById("btnUpdateOk").onclick = function() {
				f.action = "update.m2";
				f.submit();
			}
			
			document.getElementById("btnListOk").onclick = function() {
				f.action = "list.m2";
				f.submit();
			}
		}
	</script>
</head>
<body>
<%@ include file="logincheck.jsp" %>
	** 사용자 수정 **<br>
	<form name="f" method="post">
		<input type="hidden" name="userid" value="${user.userid }">
		아   이   디 : ${user.userid }<br>
		비 밀 번 호 : <input type="text" name="password" value="${user.password }"><br>
		작   성   자 : <input type="text" name="name" value="${user.name }"><br>
		이   메   일 : <input type="text" name="email" value="${user.email }"><br>
		<br>
		<input type="button" value="수 정" id="btnUpdateOk">
		<input type="button" value="목 록" id="btnListOk">
	</form>
</body>
</html>