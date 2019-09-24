package poker.domain.model.hand;

import poker.domain.model.Card;

import java.util.List;

public class TwoPair extends Hand implements Comparable<Hand> {
	private final List<Card> pair1;
	private final List<Card> pair2;


	public TwoPair(List<Card> pair1, List<Card> pair2) {
		this.pair1 = pair1;
		this.pair2 = pair2;
	}

	@Override
	public int getHandRank() {
		return 7;
	}

	@Override
	public int getSuitRank() {
		return pair2.get(pair2.size() - 1).getSuit().strength;
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

		TwoPair other = (TwoPair) o;
		int num = compareRate(this.pair2, other.pair2);
		if (num == 0) {
			return compareRate(this.pair1, other.pair1);
		}
		return num;
	}
}