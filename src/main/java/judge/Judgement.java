package judge;

import java.util.List;

import card.Card;

public class Judgement {

	public static String result(List<Card> hand) {
		PokerHand result = PokerHand.NOTHING;
		Yaku jud = new Yaku();
		jud.changeA(hand);

		if(5 <= jud.straight(hand).getMaxNum() && jud.straight(hand).getMaxNum() <= 14) {
			result = PokerHand.STRAIGHT;
		}

	    if(jud.flash(hand) == 1){
	    	result = PokerHand.FLASH;
	    }

	    if(5 <= jud.straight(hand).getMaxNum() && jud.straight(hand).getMaxNum() <= 14 && jud.flash(hand) == 1) {
	    	result = PokerHand.STRAIGHTFLASH;
		}

	    if(jud.straight(hand).getMaxNum() == 14 && jud.flash(hand) == 1) {
	    	result = PokerHand.ROYALSTRAIGHTFLASH;
		}

		if(jud.pair(hand).getPairNum().size() != 0 && jud.pair(hand).getNum() != 3 && jud.pair(hand).getNum() != 4){
			if(jud.pair(hand).getPairNum().size() == 1) {
				result = PokerHand.ONEPAIR;
			}
			if(jud.pair(hand).getPairNum().size() == 2) {
				result = PokerHand.TWOPAIR;
			}
		}

		if((jud.pair(hand).getNum() == 3 || jud.pair(hand).getNum() == 4) && jud.pair(hand).getPairNum().size() == 1){
			if(jud.pair(hand).getNum() == 3) {
				result = PokerHand.THREECARD;
			}
			if(jud.pair(hand).getNum() == 4) {
				result = PokerHand.FOURCARD;
			}
		}

		if(jud.pair(hand).getNum() == 3 && jud.pair(hand).getPairNum().size() == 2){
			result = PokerHand.FULLHOUSE;
		}

		jud.returnA(hand);

		return result.getName();
	}
}
