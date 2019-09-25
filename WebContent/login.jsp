<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
	window.onload = function() {
		var btnLogin = document.getElementById("btnLogin");
		
		btnLogin.addEventListener("click", loginFunc, false);
		document.getElementById("btnInsert").addEventListener("click", insertFunc, false);
	}
	
	function loginFunc() {
		if(form.userid.value == "") {
			alert("아이디를 입력하세요.");
			form.userid.focus();
			return false;
		}
		
		if(form.password.value == "") {
			alert("비밀번호를 입력하세요.");
			form.password.focus();
			return false;
		}
		
		form.action = "login.m2";
		form.submit();
	}
	
	function insertFunc() {
		form.action = "views/insert.jsp";
		form.submit();
	}
</script>
</head>
<body>
	* 사용자 관리 로그인(WEB MVC) *
	<form name="form" method="post">
		아 이 디  : <input type="text" name="userid"><br>
		비밀번호 : <input type="text" name="password"><br><br>
		<input type="button" value="로 그 인" id="btnLogin">
		<input type="button" value="회원가입" id="btnInsert"> 
	</form>
</body>
</html>