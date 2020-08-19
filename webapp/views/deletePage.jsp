<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 퇴사처리 화면</title>
</head>
<body>
	<h1>인사관리 사원정보 변경화면</h1>
	<form action="${pageContext.request.contextPath}/deleteEmployee.do"
		method="post">
		<h2>인사관리 퇴사처리</h2>
		<label>성명 : </label> <input type="text" name="name"><br>
		<label>사원번호 : </label> <input type="text" name="id"><br>
		<button type="submit">삭제</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>