package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class OnePair extends Hand implements Comparable<Hand> {
	private final List<Card> pair;
	private final List<Card> kicks;

	public OnePair(List<Card> pair, List<Card> kicks) {
		this.pair = pair;
		this.kicks = kicks;
	}

	@Override
	public int getHandRank() {
		return 8;
	}

	@Override
	public String getName() {
		return "1ペア";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof OnePair)) {
			return super.compareTo(o);
		}

		OnePair other = (OnePair)o;
		int num = compareRate(this.pair.get(0), other.pair.get(0));
		if (num == 0) {
			return compareRate(this.kicks, other.kicks);
		}
		return num;
	}
}
