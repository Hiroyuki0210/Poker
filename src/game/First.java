package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import card.Card;
import card.Deck;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{

    	Deck deck = new Deck();
    	List<Card> hand = new ArrayList<Card>(); //手札用の配列
    	Card ca = new Card(null,0);

    	deck.shuffle();
    	for(int i=0; i < 5; i++){
    		hand.add(deck.draw());
    	}
    	ca.sort(hand);

    	request.setAttribute("hand", hand);
    	request.setAttribute("deck",deck);

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