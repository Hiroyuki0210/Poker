<%@page import="card.Card"
		import="card.Deck"
		import="java.util.List"
		import="card.Suit"
		import="Judge.Judgement"
%>
<%
	 List<Card> hand = (List<Card>)request.getAttribute("hand");
	 Deck deck = (Deck)request.getAttribute("deck");
	 HttpSession hs = request.getSession();
	 hs.setAttribute("hand",hand);
	 hs.setAttribute("deck",deck);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第一ラウンド</title>
</head>
<body>
<div align="center"><h2>次の5枚のカードが配られました</h2> <br><br><br><br>
交換するカードを選んでください。<br><br><br>

<form action="/Poker/Second" method="GET">
<% for(int i=0; i< hand.size(); i++){ %>

<%=hand.get(i).getSuit()%><%=hand.get(i).getSuit().icon%>の<%=hand.get(i).getNum()%>
<input type="checkbox" name="num" value="<%=i%>">　　
<% } %>
<br><br><br>
<%=Judgement.getInstance().result(hand)%>
<br><br><br>
<input type="submit" value="交換する">
</form>
 <br><br><br>

<form action="/Poker/Result" method="GET"> <input type="submit" value="このまま勝負する">

 </form>

</div>
</body>
</html>


