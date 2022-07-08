<%@page import="webEx.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/page.css">
</head>
<body>


<%
UserDAO dao = UserDAO.getInstance();
String log = (String) session.getAttribute("log");

%>
<h1><%=log %>님 환영합니다!</h1>

<button onclick="location.href = '_05.board.jsp'">게시판가기</button>
<button onclick="location.href = '_00.logoutPro.jsp'">로그아웃하기</button>




</body>
</html>