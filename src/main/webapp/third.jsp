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
<title>第三ラウンド</title>
</head>
<body>
<div align="center"><h2>カードを交換しました</h2> <br><br><br><br>
交換するカードを選んでください。<br><br><br>

<form action="/Poker/Fourth" method="GET">
<% for(int i=0; i< hand.size(); i++){ %>
<%=hand.get(i).getSuit().icon%><%=hand.get(i).getStringNum()%>
<input type="checkbox" name="num" value="<%=i%>">　　
<% } %>
<br><br><br>
<%=yaku%>
<br><br><br>
<input type="submit" value="交換する">
</form>
 <br><br><br>

<%if(request.getAttribute("warn")!=null){ %>
<font color="red">交換しない場合は、"このまま勝負する"を押してください。</font><br>
<% } %>
<form action="/Poker/Result" method="GET">
<input type="submit" value="このまま勝負する">
 </form>

</div>
</body>
</html>