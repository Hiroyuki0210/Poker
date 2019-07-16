package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class FourOfAKind extends Hand implements Comparable<Hand> {
	private final List<Card> four;
	private final Card kick;

	public FourOfAKind(List<Card> four, Card kick) {
		this.four = four;
		this.kick = kick;
	}

	@Override
	public int getHandRank() {
		return 2;
	}

	@Override
	public String getName() {
		return "4カード";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof FourOfAKind)) {
			return super.compareTo(o);
		}

		FourOfAKind other = (FourOfAKind)o;
		int num = compareRate(this.four.get(0), other.four.get(0));
		if (num == 0) {
			return compareRate(this.kick, other.kick);
		}
		return num;
	}
}
