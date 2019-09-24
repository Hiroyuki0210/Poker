package poker.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//プレイヤーに関する機能
public class Player {
	private List<Card> cards;
	private String name;

	public Player(List<Card> cards, String name) {
		this.cards = cards;
		if(name == null || name.trim().equals("")){
			this.name = "player";
		}
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public String getName(){
		return name;
	}

	public void changeCard(int[] indices, List<Card> newCards) {
		List<Card> set = new ArrayList<>();
		for (int index : indices) {
			Collections.addAll(set, cards.get(index));
		}
		cards.removeAll(set);

		cards.addAll(newCards);
	}

}
