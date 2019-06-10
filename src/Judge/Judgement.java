package Judge;

import java.util.List;

import card.Card;

public class Judgement {
	public static Judgement getInstance() {
		return new Judgement();
	}

	public String result(List<Card> hand) {
		String result = "";

		String straight = "";
		String flash = "";
		String straightflash = "";
		String royalstraightflash = "";
		String pair = "";
		String card = "";
		String fullhouse = "";
		String[] type = {straight, flash, straightflash, royalstraightflash, pair, card, fullhouse};

		Judge jud = new Judge();

		jud.changeA(hand);

		if(5 <= jud.straight(hand).getMaxNum() && jud.straight(hand).getMaxNum() <= 14) {
			type[0] = "ストレート";
		}

	    if(jud.flash(hand) == 1){
	    	type[1] = "フラッシュ";
	    }

	    if(5 <= jud.straight(hand).getMaxNum() && jud.straight(hand).getMaxNum() <= 14 && jud.flash(hand) == 1) {
	    	type[2] = "ストレートフラッシュ";
		}

	    if(jud.straight(hand).getMaxNum() == 14 && jud.flash(hand) == 1) {
			type[3] = "ロイヤルストレートフラッシュ";
		}

		if(jud.pair(hand).getPairNum().size() != 0){
			type[4] = String.valueOf(jud.pair(hand).getPairNum().size())+"ペア";
		}

		if(jud.pair(hand).getNum() == 3 || jud.pair(hand).getNum() == 4){
			type[5] = String.valueOf(jud.pair(hand).getNum())+"カード";
		}

		if(jud.pair(hand).getNum() == 3 && jud.pair(hand).getPairNum().size() == 1){
			type[6] = "フルハウス";
		}

		for(int i =0; i<type.length; i++) {
			if(! type[i].equals("")) {
				result = type[i];
			}
		}

		return result;
	}
}