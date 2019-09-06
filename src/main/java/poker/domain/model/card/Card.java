package poker.domain.model.card;

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

	public String getStringNum(){
		String stringNum = String.valueOf(number);
		if(number == 1 || number == 14){
			stringNum = "A";
		}
		if(number == 11){
			stringNum = "J";
		}
		if(number == 12){
			stringNum = "Q";
		}
		if(number == 13){
			stringNum = "K";
		}
		return stringNum;
	}

}