package card;

public class Card {
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

}
