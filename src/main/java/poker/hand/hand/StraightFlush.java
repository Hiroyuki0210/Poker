package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class StraightFlush extends Hand implements Comparable<Hand> {
	private final List<Card> cards;

	public StraightFlush(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int getHandRank() {
		return 1;
	}

	@Override
	public String getName() {
		return "ストレートフラッシュ";
	}


	public int compareTo(StraightFlush o) {
		return getMaxRateCard().getNum() - o.getMaxRateCard().getNum();
	}

	private Card getMaxRateCard() {
		return cards.get(4);
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof StraightFlush)) {
			return super.compareTo(o);
		}

		StraightFlush other = (StraightFlush)o;
		return compareRate(this.cards, other.cards);
	}
}
