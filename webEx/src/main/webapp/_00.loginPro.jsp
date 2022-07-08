<%@page import="webEx.UserDTO"%>
<%@page import="webEx.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserDAO dao = UserDAO.getInstance();
UserDTO user = null;

request.setCharacterEncoding("utf-8");


String id = request.getParameter("id");
String pw = request.getParameter("pw");


String url="";


if(dao.selectUsers(id,pw) == 1){
	url = "_04.main.jsp";
	session.setAttribute("log", id);
}
else{
	url="_00.index.jsp";
	request.setAttribute("again",true);
}
request.getRequestDispatcher(url).forward(request, response);



%>
</body>
</html>