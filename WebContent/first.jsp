<%@page import="play.Card"
		import="play.CardDetail"
		import="java.util.ArrayList"
		import="java.util.Random"
 %>
<%
	Card ca = new Card();
	ArrayList<CardDetail> cd = new ArrayList<CardDetail>();

	for(int i=0; i<5; i++){
		cd.add(ca.deal());
	}

	Random rand = new Random();

	int a = rand.nextInt(ca.v());
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手札配り</title>
</head>
<body>
<div align="center"><h2>次の5枚のカードが配られました</h2></div> <br><br><br><br>

<div align="center">
<%for(int i=0; i<5; i++){ %>
<%=cd.get(i).getType()%>の<%=cd.get(i).getNum()%>　
<% } %>
</div> <br><br><br>

<div align="center">
<form action="/Poker/Second" method="GET"> <input type="submit" value="交換する"> </form> <br><br>
<form action="/Poker/Result" method="GET"> <input type="submit" value="このまま勝負する"> </form>
</div>

</body>
</html>