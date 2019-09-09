package poker.domain.model;

import java.util.Comparator;

/**
 * TODO: どんなルールで並び替えるか簡単に
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
