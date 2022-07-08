<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="js/validation.js"></script>
<link rel="stylesheet" href="css/join.css">
</head>
<body>
	<%
	try{
	boolean again =(boolean) request.getAttribute("again");
	if(again == true){%>
		<script>
		
		alert('이미 존재하는 아이디입니다.');
		
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
    <form method='get' action="_03.joinPro.jsp">
        아이디<br>
        <input type="text" class="req" required id="id" name="id" autofocus pattern="[a-z]{1}[a-z0-9]{1,7}" maxlength="20" placeholder="@naver.com">
        <br><br>
        비밀번호<br>
        <input type="password" class="req" required id="pw" name="pw" pattern="[a-zA-Z0-9@!]{8}">
        <br><br>
        비밀번호 재확인 <br>
        <input type="password" class="req" required id="checkpw" name="checkpw" pattern="[a-zA-Z0-9@!]{8}" >
        <br><br>

        이름<br>
        <input type="text" class="req" name="name" id="name" required>
       <br><br>
        생년월일<br>
        <input type="text" id="year" name="year" required placeholder="년(4자)" pattern="[0-9]{4}" title="태어난 년도 4자리를 정확하게 입력하세요.">
        <select id="month" name="month">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
        </select>
        <input type="text" id="day" name="day" class="req" required placeholder="일" pattern="[0-9]{2}" title="ex)2 -> 02로 입력해주세요.">
        <br><br>
        
        성별 <br>
        <select name="gender" >
            <option value="1">남자</option>
            <option value="2" >여자</option>
            <option value="0">선택안함</option>
        </select><br><br>
        본인 확인 이메일(선택) <br>
        <input type="text" name="email" id="email" placeholder="선택입력"><br><br>
        휴대전화 <br>
        <select id="nation" name="nation" >
            <option value="kor">대한민국</option>
            <option value="jpn">일본</option>
            <option value="usa" >미국</option>
            <option value="bra">브라질</option>
            <option value="chn">중국</option>
            <option value="vie">베트남</option>
            <option value="ru">러시아</option>
            <option value="uk">영국</option>
            <option value="ger">독일</option>
            <option value="gana">가나</option>
        </select><br><br>
        <input type="text" id="mobile" name="mobile" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####" placeholder="전화번호 입력" required> <button id="butt" style="color: white; background-color: #03c75a;">인증번호 받기</button><br><br>
        <input type="text" required placeholder="인증번호 입력하세요" style="background-color:  rgb(243, 243, 243);"> <br><br>
        <input type="button" value="가입하기" style="color: white; background-color: #03c75a;" onclick="successJoin(form)">

        
    </form>
</body>
</html>