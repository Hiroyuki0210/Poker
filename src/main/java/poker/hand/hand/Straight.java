package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class Straight extends Hand implements Comparable<Hand> {
	private final List<Card> cards;

	public Straight(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int getHandRank() {
		return 5;
	}

	@Override
	public String getName() {
		return "ストレート";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof Straight)) {
			return super.compareTo(o);
		}

		Straight other = (Straight)o;
		return compareRate(this.cards, other.cards);
	}
}
