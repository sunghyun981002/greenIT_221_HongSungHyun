<%@page import="webEx.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/page.css">
<title>Insert title here</title>
</head>
<body>
	<%
	try{
	boolean again =(boolean) request.getAttribute("again");
	if(again == true){%>
		<script>
		
		alert('존재 하지않는 정보입니다. 회원가입을 진행해주세요.');
		
		</script>
	<% }
		
	}
	catch (Exception e){
		e.printStackTrace();
	}
	%>
    <br><br><br>
    <img src="naver_logo.png" href="http://www.naver.com" width="240px" height="44px">
    <br><br><br>
<h1>LOGIN</h1>
<form method='post' action="./login">
<input type='text' name='id' placeholder="id">
<input type='text' name='pw' placeholder="pw">
<div class="button">
<input type="submit" value="로그인" >
<input type="button" value="가입하기"  onclick="location.href='_01.agree.jsp'">
</button>
</div>

</form>

</body>
</html>