package poker.hand.hand;

public class RoyalStraightFlush extends Hand implements Comparable<Hand> {
	@Override
	public int getHandRank() {
		return 0;
	}

	@Override
	public String getName() {
		return "ロイヤルストレートフラッシュ";
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof RoyalStraightFlush)) {
			return super.compareTo(o);
		}
		return 0;
	}
}
