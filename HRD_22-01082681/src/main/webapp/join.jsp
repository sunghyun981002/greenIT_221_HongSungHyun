<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="./joinPro.jsp">

회원이름 : <input type="text" id="name" name="name" placeholder="name" required="required"><br>
전화번호 : <input type="text" id="phone" name="phone" pattern="[0-9]{11}" placeholder="ex) 010-1111-1111" ><br><!-- -[0-9]{4}-[0-9]{4} -->
통신사 :<select name="address" >
            <option value="SK">SK</option>
            <option value="KT" >KT</option>
            <option value="LG">LG</option>
        </select><br>

거주도시 :<select name="city" >
            <option value="01">서울특별시</option>
            <option value="02" >대전광역시</option>
            <option value="03">부산광역시</option>
            <option value="04">인천광역시</option>
            <option value="05" >대구광역시</option>
            <option value="06">울산광역시</option>
            <option value="07">광주광역시</option>
            <option value="08" >세종특별자치시</option>
        </select><br>
        
        <input type="submit" value="가입하기">
</form>
</body>
</html>