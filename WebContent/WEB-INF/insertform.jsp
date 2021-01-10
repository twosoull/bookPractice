<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 등록</h1>
	<form action="/phonebook001/pbc" method= "get">
		<input type = "text" name = "name">
		<input type = "text" name = "hp">
		<input type = "text" name = "company">
		<input type = "hidden" name = "action" value="insert">
		<button type = "submit">등록</button>
	</form>
	
	<a href = "/phonebook001/pbc?actionlist">리스트로 돌아가기</a>
</body>
</html>