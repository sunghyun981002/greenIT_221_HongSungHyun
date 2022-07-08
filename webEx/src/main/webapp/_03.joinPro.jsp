<%@page import="webEx.UserDTO"%>
<%@page import="webEx.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinPro</title>
</head>
<body>


	<%--
//post 메소드로 전달된 파라미터 값 확인 
id
pw
name
year
month
day
gender
email
nation
mobile
--%>

<% 
	// 요청 받은 데이터에 대한 컨트롤 -> 자바를 통함 

	//자바빈 : 요청된 데이터에 대한 자료처리 방식
	// ㄴ vo :read-only
	// ㄴ DTO : 요청 데이터를 -> 트랙잭션 처리하기 위한 -> 임시 객체 

	// ㄴ DAO : 연동된 데이터(중앙)에 대한 요청 내용 실제 처리 해주는 객체
	// ㄴ singletone 패턴 적용 
	UserDAO dao = UserDAO.getInstance();
	UserDTO user = null;

	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String checkpw = request.getParameter("checkpw");
	String name = request.getParameter("name");
	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int day = Integer.parseInt(request.getParameter("day"));
	int gender = Integer.parseInt(request.getParameter("gender"));
	String email = request.getParameter("email");
	String nation = request.getParameter("nation");
	String mobile = request.getParameter("mobile");

	user = new UserDTO(id, pw, checkpw, name, year, month, day, gender, email, nation, mobile);
	String url = "";
	
		//회원 가입 성공 
		//login.jsp로 페이지로 이동 
		if(dao.insertUsers(user)){
		url = "_00.index.jsp";			
		}
		else{

		url = "_02.join.jsp";
		request.setAttribute("again",true);
		 }
	
	//1.단순 리다이렉트
	// response.sendRedirect(url);
	//2. 이전 페이지에서 가지고 온 request & response 객체를 그대로 다음페이지로 전달 
	//request.setAttribute("log", user.getId());    
	request.getRequestDispatcher(url).forward(request, response);

	//3. 톰캣 세션을 활용한 session 에 로그 정보 넣기 
	//session.setAttribute("log",user.getId());
	%>
</body>
</html>