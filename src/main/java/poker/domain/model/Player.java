package poker.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import poker.domain.model.PlayerName;

//プレイヤーに関する機能
public class Player {
	private List<Card> cards;
	private String name;

	//引数indは、PlayerNameクラスで割り振られている番号
	public Player(List<Card> cards, int ind) {
		this.cards = cards;

		for (PlayerName playerName : PlayerName.values()) {
			if (playerName.getIndex() == ind) {
				name = playerName.getName();
			}
		}
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
