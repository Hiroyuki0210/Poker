package poker;

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
	public Card draw() {
		Card ca = cards.get(cards.size() -1);
		cards.remove(cards.size()-1);

		return ca;
	}

}
