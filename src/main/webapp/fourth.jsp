<%@page import="poker.hand.Card"
		import="poker.hand.Deck"
		import="java.util.List"
		import="poker.hand.hand.Hand"
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
<title>ファイナルラウンド</title>
</head>
<body>
<div align="center"><h2>カードを交換しました</h2> <br><br><br><br>
こちらの手札で勝負します<br><br><br>

<% for(int i=0; i< hand.size(); i++){ %>
<%=hand.get(i).getSuit()%><%=hand.get(i).getSuit().icon%>の<%=hand.get(i).getNum()%>　　
<% } %>
<br><br><br>
<%=Hand.getHand(hand).getName()%>
 <br><br><br>

<form action="/Poker/Result" method="GET">
 <input type="submit" value="勝負する">
</form>

</div>
</body>
</html>