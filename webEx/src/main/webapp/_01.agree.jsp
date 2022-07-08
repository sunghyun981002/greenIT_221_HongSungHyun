<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>naverAcceptForm</title>
<link rel="stylesheet" href="css/page.css">
<script src="js/validation.js"></script>
</head>
<body>
    <br><br><br>
    <img src="naver_logo.png" href="http://www.naver.com" width="240px" height="44px">
    <br><br><br>
<form method='get' action="_02.join.jsp">
<label><input type="checkbox" name ="check" onclick="selectAll(this)"><a style="font-size: 22px">네이버 이용약관, 개인정보 수집 및 이용 ,위치 정보 이용약관<br>
(선택), 프로모션 정보 수신(선택)에 모두 동의합니다.</a></label>
<br><br>

<label><input type="checkbox" name="check" value="1"><a style="font-size: 22px">네이버 이용 약관 동의</a><a style="color: green">(필수)</a></label><br><br>
<div style="border:1px solid; padding:10px; width: 500px; height: 100px;" >여러분을 환영합니다.
    네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 
    이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
    </div><br><br>

<label><input type="checkbox" name="check" value="2"><a style="font-size: 22px">개인정보 수집 및 이용 동의</a><a style="color: green">(필수)</a></label><br><br>
<div style="border:1px solid; padding:10px; width: 500px; height: 100px;" >개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 
    개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
    <br>1. 수집하는 개인정보</div><br><br>

<label><input type="checkbox" name="check" value="3"><a style="font-size: 22px">위치기반서비스 이용약관 동의</a><a style="color: gray">(선택)</a></label><br><br>
<div style="border:1px solid; padding:10px; width: 500px; height: 100px;" >위치기반서비스 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 네이버 위치기반 서비스를 이용할 수 있습니다.
    <br>제 1 조 (목적)
    <br>이 약관은 네이버 주식회사 (이하 “회사”)가 제공하는 위치기반서비스와 관련하여 회사와 개인위치정보주체와의 권리, 의무 및 책임사항, 기타 필요한 사항</div><br><br>

<label><input type="checkbox" name="check" value="4"><a style="font-size: 22px">프로모션 정보 수신 동의</a><a style="color: gray">(선택)</a></label><br>
<div>네이버에서 제공하는 이벤트/혜택 등 다양한 정보를 휴대전화(네이버앱 알림 또는 문<br>
자), 이메일로 받아보실 수 있습니다. 일부 서비스(별도 회원 체계로 운영하거나 네이<br>
버 가입 이후 추가 가입하여 이용하는 서비스 등)의 경우, 개별 서비스에 대해 별도 수<br>
신 동의를 받을 수 있으며, 이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니<br>
다.</div><br>
<div class="backMessege"> </div><br>
<input type="button" value="취소" id="x" onclick="location.href='http://www.naver.com'">
<input type="button" value="제출" onclick="checkValue(form)" id="o" style="color: white; background-color: #03c75a;">

</form>

</body>
</html>