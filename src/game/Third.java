package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import card.Card;
import card.Deck;

/**
 * Servlet implementation class Third
 */
@WebServlet("/Third")
public class Third extends HttpServlet {

	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException{


	    	HttpSession hs = request.getSession();
	    	Deck deck = (Deck)hs.getAttribute("deck");
	    	List<Card> hand = (List<Card>)hs.getAttribute("hand");
	    	List<Card> set = new ArrayList<>();
	    	Card ca = new Card(null,0);

	    	String [] changenum = request.getParameterValues("num");

	    	//削除するカードをsetに格納
	    	for(int i=0; i < changenum.length; i++){
	    		Collections.addAll(set, hand.get(Integer.parseInt(changenum[i])) );
	    		hand.add(deck.draw());
	    	}
	    	hand.removeAll(set);

	    	ca.sort(hand);

	    	hs.setAttribute("hand", hand);
	    	hs.setAttribute("deck",deck);

	    	request.getRequestDispatcher("/third.jsp").forward(request,response);
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