package card;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Card{
	private Suit suit;
	private int number;

	public Card(Suit suit, int num) {
		this.suit = suit;
		this.number = num;
	}

	public String print() {
		return "Num: "  + this.number + ", Suit: "  + this.suit.icon;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getNum() {
		return number;
	}

	//手札の並び替え
	public void sort(List<Card> hand) {
	// Comparatorを実装した匿名クラス
    Comparator<Card> comparator = new Comparator<Card>() {
        @Override
        public int compare(Card c1, Card c2) {
            return c1.getNum() < c2.getNum() ? -1 : 1;
        }
    };
    Collections.sort(hand, comparator);
	}

}
