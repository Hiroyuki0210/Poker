package poker.hand.hand;

public class Nothing extends Hand implements Comparable<Hand> {
	static final Nothing Instance = new Nothing();

	@Override
	public int getHandRank() {
		return 9;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public int compareTo(Hand o) {
		if (!(o instanceof Nothing)) {
			return super.compareTo(o);
		}

		return 0;
	}
}
