<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 사원정보 변경화면</title>
</head>
<body>
	<h1>인사관리 사원정보 변경화면</h1>
	<form action="${pageContext.request.contextPath}/insertEmployee.do" method="post">
		<legend>인사관리 사원정보 변경</legend>
		<label>성명 : </label>
		<input type="text" name="name"><br>
		<label>사원번호 : </label>
		<input type="text" name="id"><br>
		<label>소속부서 : </label>
		<select name="dept">
			<option value="인사부">인사부</option>
			<option value="기획부">기획부</option>
			<option value="홍보부">홍보부</option>
			<option value="영업부">영업부</option>
			<option value="경리부">경리부</option>
		</select><br>
		<label>직급 : </label>
		<select name="position">
			<option value="1">1급</option>
			<option value="2">2급</option>
			<option value="3">3급</option>
			<option value="4">4급</option>
		</select><br>
		<label>직책 : </label>
		<input type="text" name="duty"><br>
		<label>연락처 : </label>
		<input type="text" name="phone"><br>
		<button type="submit">등록</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>