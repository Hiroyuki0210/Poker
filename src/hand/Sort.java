package hand;

import java.util.ArrayList;

import card.Card;

public class Sort {

	//手札の番号をを小さい順に並べる(バブルソート)
	public ArrayList<Card> sort(ArrayList<Card> hand){
		  for (int i = 0; i < hand.size() - 1; i++) {
		    for (int j = hand.size() - 1 ; j > i; j--) {
		      if (hand.get(j-1).getNum() > hand.get(j).getNum()) {
		    	  Card ca = hand.get(j-1);
		    	  hand.set(j-1, hand.get(j));
		    	  hand.set(j, ca);
		      }
		    }
		  }
		  return hand;
	}

}
