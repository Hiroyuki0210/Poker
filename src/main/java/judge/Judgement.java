package judge;

import java.util.List;

import card.Card;

public class Judgement {

	public static PokerHand result(List<Card> hand) {
		PokerHand result = PokerHand.NOTHING;
		Yaku jud = new Yaku(hand);
		jud.changeA();

		if(5 <= jud.straight().getMaxNum() && jud.straight().getMaxNum() <= 14) {
			result = PokerHand.STRAIGHT;
		}

		if(jud.flash() == 1){
			result = PokerHand.FLASH;
		}

		if(5 <= jud.straight().getMaxNum() && jud.straight().getMaxNum() <= 14 && jud.flash() == 1) {
			result = PokerHand.STRAIGHTFLASH;
		}

		if(jud.straight().getMaxNum() == 14 && jud.flash() == 1) {
			result = PokerHand.ROYALSTRAIGHTFLASH;
		}

		if(jud.pair().getPairCard().size() != 0 && jud.pair().getNum() != 3 && jud.pair().getNum() != 4){
			if(jud.pair().getPairCard().size() == 1) {
				result = PokerHand.ONEPAIR;
			}
			if(jud.pair().getPairCard().size() == 2) {
				result = PokerHand.TWOPAIR;
			}
		}

		if((jud.pair().getNum() == 3 || jud.pair().getNum() == 4) && jud.pair().getPairCard().size() == 1){
			if(jud.pair().getNum() == 3) {
				result = PokerHand.THREECARD;
			}
			if(jud.pair().getNum() == 4) {
				result = PokerHand.FOURCARD;
			}
		}

		if(jud.pair().getNum() == 3 && jud.pair().getPairCard().size() == 2){
			result = PokerHand.FULLHOUSE;
		}

		jud.returnA();

		return result;
	}
}