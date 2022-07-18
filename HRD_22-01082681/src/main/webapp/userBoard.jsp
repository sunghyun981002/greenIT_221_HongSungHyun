<%@page import="user.UserDTO"%>
<%@page import="java.util.ArrayList"%>
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
   <div class="boardListContainer">
        <table border="1">
         <thead>
                <th>회원번호</th>
                <th>회원성명</th>
                <th>연락처</th>
                <th>통신사</th>
                <th>가입일자</th>
                <th>고객등급</th>
                <th>도시코드</th>
            </thead>
            <tbody>
            	<%
            	UserDAO userDao = UserDAO.getInstance();
            	ArrayList<UserDTO> list = userDao.getAllrow(); 
            	for(int i = 0; i<list.size(); i++){%>
            	<tr>
                    <td><%=list.get(i).getCustno()%></td>
                    <td><%=list.get(i).getCustname()%></td>
                    <td><%=list.get(i).getPhone()%></td>
                    <td><%=list.get(i).getAddress()%></td>
                    <td><%=list.get(i).getJoindate()%></td>
                    <td><%=list.get(i).getGrade()%></td>
                    <td><%=list.get(i).getCity()%></td>                  

 
                </tr>
            	<%}
            	%>
            </tbody>
        </table>

</body>
</html>