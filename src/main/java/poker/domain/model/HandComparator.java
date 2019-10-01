package poker.domain.model;

import java.util.Comparator;
import java.util.List;

import poker.domain.model.hand.Hand;

/**
 * 手札の強さの評価。
 * 基本的に数字の小さい順。数字が同じ場合はスートが弱い順。
 */
public class HandComparator implements Comparator<Player> {
	@Override
	public int compare(Player p1, Player p2) {
          List<Card> c1 = p1.getCards();
          List<Card> c2 = p2.getCards();

          int a = Hand.getHand(c2).compareTo(Hand.getHand(c1));

          if (a  == 0) {
               return Hand.getHand(c2).getSuitRank() - Hand.getHand(c1).getSuitRank();
          }

          return a;
	}
}