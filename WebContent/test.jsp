<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import = "java.util.List"
	import = "java.util.ArrayList"
	import = "card.Card"
	import = "card.Suit"
	import = "Judge.Judgement"
%>

<%
	//Deck de = new Deck();

	List<Card> hand = new ArrayList<Card>();
	hand.add(new Card(null, 2));
	hand.add(new Card(Suit.SPADE, 3));
	hand.add(new Card(Suit.SPADE, 4));
	hand.add(new Card(Suit.SPADE, 5));
	hand.add(new Card(Suit.SPADE, 6));


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=Judgement.result(hand)%> <br>

</body>

</html>