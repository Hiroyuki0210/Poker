package poker.domain.service;

import poker.domain.model.Card;
import poker.domain.model.hand.Hand;

import java.util.List;

// プレイヤーの手札情報
public class PlayerHandDetail {
	private List<Card> cards;
	private Hand hand;

	public PlayerHandDetail(List<Card> cards, Hand hand) {
		this.cards = cards;
		this.hand = hand;
	}

	public List<Card> getCards() {
		return cards;
	}

	public Hand getHand() {
		return hand;
	}
}
