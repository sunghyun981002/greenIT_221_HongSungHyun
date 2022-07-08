<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.HashMap"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.Map"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/board.css">
<title>BOARD LIST</title>
</head>
<body>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<table border="1">
			<thead>
				<th>no</th>
				<th>code</th>
				<th>title</th>
				<th>viewCnt</th>
				<th>likeCnt</th>
				<th>createdAt</th>
				<th>modifiedAt</th>
			</thead>
			<tbody>
					<%
					BoardDAO bDao = BoardDAO.getInstance();
					Map<Integer, BoardDTO> temp = bDao.getMap();
					Object[] keySet = temp.keySet().toArray();
						//int no = 0;
						//int code = 0;
						int no = 0; 
						int code = 0; 
						String title = null;
						String content = null; 
						int viewCnt = 0;
						int likeCnt = 0;
						Date date = new Date();
						
						Timestamp createdAt = new Timestamp(date.getTime());
						Timestamp modifiedAt = null;
						//Date createdAt = null;
						//Date modifiedAt = null;
						
						for(Object k : keySet) {
							no = temp.get(k).getNo();
							code = temp.get(k).getCode();
							title = temp.get(k).getTitle();
							content = temp.get(k).getContent();
							viewCnt = temp.get(k).getViewCnt();
							likeCnt = temp.get(k).getLikeCnt();
							createdAt = temp.get(k).getCreatedAt();
							modifiedAt = temp.get(k).getModifiedAt();
					%>
					<tr>
					<td><%=no%></td>
					<td><%=code%></td>
					<td><a href ="_08.boardView.jsp?code=<%=code%>"><%=title%></a></td>
					<td><%=viewCnt%></td>
					<td><%=likeCnt%></td>
					<td><%=createdAt%></td>
					<td><%=modifiedAt%></td>
					<%
					}
					%>
				</tr>
			</tbody>
		</table>
		    <button id ="button1" onclick = "location.href ='_06.boardWriteForm.jsp">작성하기</button>
	</div>
</body>
</html>