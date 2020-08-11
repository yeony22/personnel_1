<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회결과</title>
</head>
<body>
	<h1>직원 정보 조회 결과</h1>
	<table border=1>
		<tr>
			<th>성명</th>
			<th>사번</th>
			<th>직급</th>
			<th>직책</th>
			<th>연락처</th>
			<th>소속부서</th>		
		</tr>
		<c:forEach items="${list}" var="personnel">
			<tr>
				<td>${personnel.name}</td>
				<td>${personnel.id}</td>
				<td>${personnel.position}</td>
				<td>${personnel.duty}</td>
				<td>${personnel.phone}</td>
				<td>${personnel.dept}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>