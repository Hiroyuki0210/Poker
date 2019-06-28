package card;

public class Card{
	private Suit suit;
	private int number;

	public Card(Suit suit, int num) {
		this.suit = suit;
		this.number = num;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getNum() {
		return number;
	}

}
