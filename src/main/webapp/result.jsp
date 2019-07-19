<%@page import="poker.Card"
		import="poker.Deck"
		import="poker.Suit"
		import="poker.hand.Hand"
		import="java.util.List"
%>
<%
	 HttpSession hs = request.getSession();
	 List<Card> hand = (List<Card>)hs.getAttribute("hand");
	 Deck deck = (Deck)hs.getAttribute("deck");
	 String yaku = Hand.getHand(hand).getName();
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

<%=hand.get(i).getSuit().icon%><%=hand.get(i).getStringNum()%>　
<% } %>
<br><br><br>
<%=yaku%>
<br><br><br>

<a href="/Poker/top.jsp">ゲームを終了する</a>
</div>

<% hs.invalidate();%>
</body>
</html>