package poker.domain.model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> cards;

	//52枚のカードをデッキにセットするコンストラクタ
	public Deck() {
		this.cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for(int j = 1; j <= 13; j++) {
				cards.add(new Card(suit, j));
			}
		}
		Collections.shuffle(cards);
	}

	//一番上のカードを引く,引いたカードはデッキから外す
	public List<Card> draw(int size) {
		List<Card> drawCards = new ArrayList<>();
		for(int i=0; i<size; i++){
			Card topCard = cards.remove(cards.size() -1);
			drawCards.add(topCard);
		}
		return drawCards;
	}
}
