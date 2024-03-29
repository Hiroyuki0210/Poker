//package poker.app.controllers;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import poker.domain.model.Deck;
//import poker.domain.model.Card;
//
///**
// * Servlet implementation class Second
// */
//@WebServlet("/Second")
//
//public class Second extends HttpServlet {
//
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		HttpSession hs = request.getSession();
//		Deck deck = (Deck)hs.getAttribute("deck");
//		List<Card> hand = (List<Card>)hs.getAttribute("hand");
//
//		//交換するカードを選んだ場合は交換&次ページに進む、選ばなかった場合は前のページに戻る
//		try{
//			PlayerHand.changeCard(hand, deck, request.getParameterValues("num"));
//			PlayerHand.sort(hand);
//
//			hs.setAttribute("hand", hand);
//			hs.setAttribute("deck",deck);
//
//			request.getRequestDispatcher("/second.jsp").forward(request,response);
//		}catch(NullPointerException e) {
//			request.setAttribute("warn", 1);
//			request.getRequestDispatcher("/first.jsp").forward(request,response);
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest(request,response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		processRequest(request,response);
//	}
//
//}
