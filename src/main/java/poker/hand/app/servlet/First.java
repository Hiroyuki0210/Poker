package poker.hand.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import poker.hand.Card;
import poker.hand.Deck;
import poker.hand.PlayerHand;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//山札用意
		Deck deck = new Deck();
		//プレイヤー側の手札
		List<Card> hand = new ArrayList<Card>();
		HttpSession hs = request.getSession();

		//プレイヤーとCPUの手札を配る
		for(int i=0; i < 5; i++){
			hand.add(deck.draw());
		}
		//手札を数字の小さい順に並べる
		PlayerHand.sort(hand);

		hs.setAttribute("hand",hand);
		hs.setAttribute("deck",deck);

		request.getRequestDispatcher("/first.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
}