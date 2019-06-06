package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	public List<Card> cards;

	//52枚のカード(スートを区別)をデッキにセットする
	public Deck() {
		this.cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for(int j = 1; j <= 13; j++) {
				cards.add(new Card(suit, j));
			}
		}
	}

	//カードをきる
	public void shuffle() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		Random rand = new Random();

		for(int i=0; i < cards.size(); i++ ) {
			int ind = rand.nextInt(cards.size());
			shuffledDeck.add(cards.get(ind));
		}
		this.cards = shuffledDeck;
	}

	//一番上のカードを引く
	public Card draw() {
		return cards.get(cards.size() -1);
	}

	//引いたカードをデッキから外す
	public void Delete() {
		cards.remove(cards.size()-1);
	}

}
