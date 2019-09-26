<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세 보기</title>
	<script type="text/javascript">
		window.onload = function() {
			document.getElementById("btnUpdate").onclick = function() {
				if(confirm("정말 수정할까요?")) {
					f.action = "updateform.m2";
					f.submit();
				}
			}
			
			document.getElementById("btnDelete").onclick = function() {
				if(confirm("정말 삭제할까요?")) {
					f.action = "delete.m2";
					f.submit();
				}
			}
			
			document.getElementById("btnList").onclick = function() {
					f.action = "list.m2";
					f.submit();
				}
		}
	</script>	
</head>
<body>
	* 회원 상세 보기 * <br>
	<table border="1">
		<tr>
			<td>아 이 디</td><td>${user.userid }</td>
			<td>비밀번호</td><td>${user.password }</td>
		</tr>
		<tr>
			<td>사 용 자 </td><td>${user.name }</td>
			<td>이 메 일 </td><td>${user.email }</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<button id="btnUpdate">수 정</button>
				<button id="btnDelete">삭 제 </button>
				<button id="btnList">목 록</button>
			</td>
		</tr>
	</table>
	<form name="f" method="post">
		<input type="hidden" name="userid" value="${user.userid }">
	</form>
</body>
</html>