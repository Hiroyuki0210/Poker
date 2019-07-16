package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class ThreeOfAKind extends Hand implements Comparable<Hand> {
	private final List<Card> three;
	private final List<Card> kicks;

	public ThreeOfAKind(List<Card> three, List<Card> kicks) {
		this.three = three;
		this.kicks = kicks;
	}

	@Override
	public int getHandRank() {
		return 6;
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

		ThreeOfAKind other = (ThreeOfAKind)o;
		int num = compareRate(this.three.get(0), other.three.get(0));
		if (num == 0) {
			return compareRate(this.kicks, other.kicks);
		}
		return num;
	}
}
