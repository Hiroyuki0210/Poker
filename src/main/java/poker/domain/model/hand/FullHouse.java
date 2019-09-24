package poker.domain.model.hand;

import poker.domain.model.Card;

import java.util.List;

public class FullHouse extends Hand implements Comparable<Hand> {
	private final List<Card> three;

	public FullHouse(List<Card> three) {
		this.three = three;
	}

	@Override
	public int getHandRank() {
		return 3;
	}

	@Override
	public int getSuitRank() {
		return three.get(three.size() - 1).getSuit().strength;
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

		FullHouse other = (FullHouse) o;
		int num = compareRate(this.three, other.three);

		return num;
	}
}