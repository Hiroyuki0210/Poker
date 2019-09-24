package poker.domain.model.hand;

import poker.domain.model.Card;

import java.util.List;

public class ThreeOfAKind extends Hand implements Comparable<Hand> {
	private final List<Card> cards;

	public ThreeOfAKind(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int getHandRank() {
		return 6;
	}

	@Override
	public int getSuitRank() {
		return cards.get(cards.size() - 1).getSuit().strength;
	}

	@Override
	public String getName() {
		return "3カード";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof ThreeOfAKind)) {
			return super.compareTo(o);
		}

		ThreeOfAKind other = (ThreeOfAKind) o;
		return compareRate(this.cards, other.cards);
	}
}