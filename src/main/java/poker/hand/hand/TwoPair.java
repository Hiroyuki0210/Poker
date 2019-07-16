package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class TwoPair extends Hand implements Comparable<Hand>{
	private final List<Card> pair1;
	private final List<Card> pair2;
	private final Card kick;

	public TwoPair(List<Card> pair1, List<Card> pair2, Card kick) {
		this.pair1 = pair1;
		this.pair2 = pair2;
		this.kick = kick;
	}

	@Override
	public int getHandRank() {
		return 7;
	}

	@Override
	public String getName() {
		return "2ペア";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof TwoPair)) {
			return super.compareTo(o);
		}

		TwoPair other = (TwoPair)o;
		int num = compareRate(this.pair1.get(0), other.pair1.get(0));
		if (num == 0) {
			num = compareRate(this.pair2.get(0), other.pair2.get(0));
		}
		if (num == 0) {
			return compareRate(this.kick, other.kick);
		}
		return num;
	}
}
