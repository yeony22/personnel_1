<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리조회화면</title>
</head>
<body>
	<h1>인사관리조회화면</h1>
	<form action="${pageContext.request.contextPath}/newselectEmployee.do" method="get">
		<div>인사관리 조회</div>
		사원번호로 조회
		<input type="text" name="keyword" />
		<button type="submit">조회</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>