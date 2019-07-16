package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class Flush extends Hand implements Comparable<Hand> {
	private final List<Card> cards;

	public Flush(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int getHandRank() {
		return 4;
	}

	@Override
	public String getName() {
		return "フラッシュ";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof Flush)) {
			return super.compareTo(o);
		}

		Flush other = (Flush)o;
		return compareRate(this.cards, other.cards);
	}
}
