package poker.hand.hand;

import poker.hand.Card;

import java.util.List;

public class FullHouse extends Hand implements Comparable<Hand> {
	private final List<Card> three;
	private final List<Card> pair;

	public FullHouse(List<Card> three, List<Card> pair) {
		this.three = three;
		this.pair = pair;
	}

	@Override
	public int getHandRank() {
		return 3;
	}

	@Override
	public String getName() {
		return "フルハウス";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof FullHouse)) {
			return super.compareTo(o);
		}

		FullHouse other = (FullHouse)o;
		int num = compareRate(this.three.get(0), other.three.get(0));
		if (num == 0) {
			return compareRate(this.pair.get(0), other.pair.get(0));
		}
		return num;
	}
}
