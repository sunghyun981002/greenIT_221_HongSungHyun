<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
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
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
UserDAO dao = UserDAO.getInstance();


String name = request.getParameter("name");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String city = request.getParameter("city");

UserDTO dto = new UserDTO(name,phone,address,city);

String url ="";

if(dao.addUser(dto)){
	System.out.println(" 1212 회원가입성공! ");
	url = "./index.jsp";
}
else {
	System.out.println(" 1212회원가입 실패!");
	url ="./join.jsp";
}
request.getRequestDispatcher(url).forward(request, response);

%>
</body>
</html>