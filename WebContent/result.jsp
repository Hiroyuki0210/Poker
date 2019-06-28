<%@page import="card.Card"
		import="card.Deck"
		import="java.util.List"
		import="card.Suit"
		import="Judge.Judgement"
%>
<%
	 HttpSession hs = request.getSession();
	 List<Card> hand = (List<Card>)hs.getAttribute("hand");
	 Deck deck = (Deck)hs.getAttribute("deck");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
<div align="center"><h2>結果</h2> <br><br><br><br>

<% for(int i=0; i< hand.size(); i++){ %>

<%=hand.get(i).getSuit()%><%=hand.get(i).getSuit().icon%>の<%=hand.get(i).getNum()%>　
<% } %>
<br><br><br>
<%=Judgement.result(hand)%>
<br><br><br>

<a href="/Poker/top.jsp">ゲームを終了する</a>
</div>

<% hs.invalidate();%>
</body>
</html>