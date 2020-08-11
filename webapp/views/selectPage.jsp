<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리조회화면</title>
</head>
<body>
	<h1>인사관리조회화면</h1>
	<div>인사관리 조회</div>
	<input type="radio" /> 사원번호로 조회
	<input type="text" /> 부서명으로 조회
	<select name="dept">
		<option value="인사부">인사부</option>
		<option value="홍보부">홍보부</option>
		<option value="경리부">경리부</option>
		<option value="기획부">기획부</option>
		<option value="영업부">영업부</option>
	</select>
	<button type="submit">조회</button>
	<button type="reset">취소</button>
</body>
</html>