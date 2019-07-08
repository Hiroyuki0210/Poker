<%
	HttpSession hs =  request.getSession();
	hs.removeAttribute("hand");
	hs.removeAttribute("deck");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ</title>
</head>
<body>
<div align="center">
<h1>ポーカー</h1> <br><br>
<h3>ポーカーを始めます!!下のボタンを押してください!!</h3> <br><br>

<form action="/Poker/First" method="GET">
<input type="submit" value="スタート">
</form>
</div>
</body>
</html>