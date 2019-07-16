package poker.hand.hand;

import poker.hand.Card;
import poker.hand.Suit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hand implements Comparable<Hand> {
	public abstract int getHandRank();
	public abstract String getName();

	public int compareTo(Hand o) {
		return o.getHandRank() - this.getHandRank();
	}

	public static Hand getHand(List<Card> hand) {
		boolean isFlush = isFlush(hand);
		boolean isStraight = isStraight(hand);

		if (isStraight && isFlush) {
			if (hand.get(0).getNum() == 1 && hand.get(4).getNum() == 13) {
				return new RoyalStraightFlush();
			}

			return new StraightFlush(hand);
		}

		Hand pairHand = getPairs(hand);
		if (pairHand instanceof FourOfAKind || pairHand instanceof FullHouse) {
			return pairHand;
		}

		if (isFlush) return new Flush(hand);
		if (isStraight) return new Straight(hand);

		return pairHand;
	}


	static boolean isStraight(List<Card> hand) {
		int min, last;
		min = last = hand.get(1).getNum();

		for (int id = 2; id < hand.size(); id++) {
			Card card = hand.get(id);
			if (last + 1 != card.getNum()) {
				return false;
			}
			last = card.getNum();
		}

		int top = hand.get(0).getNum();
		return top + 1 == min || (last == 13 && top == 1);
	}

	static boolean isFlush(List<Card> hand) {
		Suit suit = hand.get(0).getSuit();

		for (Card card : hand) {
			if (suit != card.getSuit())
				return false;
		}

		return true;
	}

	static Hand getPairs(List<Card> hand) {
		// 出現頻度
		Map<Integer, List<Card>> temp = new HashMap<>();
		for (Card card : hand) {
			List<Card> value = temp.getOrDefault(card.getNum(), new ArrayList<>());
			value.add(card);
			temp.put(card.getNum(), value);
		}

		// 2ペア以上とキッカーに分類する
		Map<Integer, List<Card>> counter = new HashMap<>();
		List<Card> kickers = new ArrayList<>();
		for(Map.Entry<Integer, List<Card>> entry : temp.entrySet()) {
			if (entry.getValue().size() == 1) {
				kickers.addAll(entry.getValue());
			} else {
				counter.put(entry.getKey(), entry.getValue());
			}
		}

		List<List<Card>> values = new ArrayList<>(counter.values());

		switch (kickers.size()) {
			case 0:
				List<Card> c1 = values.get(0);
				List<Card> c2 = values.get(1);

				if (c1.size() == 3) {
					return new FullHouse(c1, c2);
				} else {
					return new FullHouse(c2, c1);
				}
			case 1:
				if (counter.size() == 1) {
					return new FourOfAKind(values.get(0), kickers.get(0));
				} else {
					return new TwoPair(values.get(0), values.get(1), kickers.get(0));
				}
			case 2:
				return new ThreeOfAKind(values.get(0), kickers);
			case 3:
				return new OnePair(values.get(0), kickers);
			default:
				return Nothing.Instance;
		}
	}

	static int compareRate(List<Card> listA, List<Card> listB) {
		assert listA.size() == listB.size();

		for (int id = 0; id < listA.size(); id++) {
			Card a = listA.get(id);
			Card b = listB.get(id);

			int num = compareRate(a, b);
			if (num != 0) return num;
		}

		return 0;
	}

	static int compareRate(Card ca, Card cb) {
		return ca.getNum() - cb.getNum();
	}
}
