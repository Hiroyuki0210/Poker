package game;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import card.Card;
import card.Deck;
import player.PlayerHand;

/**
 * Servlet implementation class Fourth
 */
@WebServlet("/Fourth")
public class Fourth extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		HttpSession hs = request.getSession();
		Deck deck = (Deck)hs.getAttribute("deck");
		List<Card> hand = (List<Card>)hs.getAttribute("hand");

		try {
			PlayerHand.changeCard(hand, deck, request.getParameterValues("num"));
			PlayerHand.sort(hand);

			hs.setAttribute("hand", hand);
			hs.setAttribute("deck",deck);

			request.getRequestDispatcher("/fourth.jsp").forward(request,response);
		}catch(NullPointerException e) {
			request.setAttribute("warn", 1);
			request.getRequestDispatcher("/third.jsp").forward(request,response);
		}
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