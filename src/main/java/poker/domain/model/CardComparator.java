package poker.domain.model;

import java.util.Comparator;


/**
 * 手札の並び替え。
 * 基本的に数字の小さい順。数字が同じ場合はスートが弱い順。
 */
public class CardComparator implements Comparator<Card> {
	@Override
	public int compare(Card c1, Card c2) {
		int a = c1.getNum() - c2.getNum();
		if (a == 0) {
			return c1.getSuit().strength - c2.getSuit().strength;
		}
		return a;
	}
}
