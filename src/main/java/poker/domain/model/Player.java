package poker.domain.model;

import java.util.Comparator;
import java.util.List;

public class Player {
    private List<Card> cards;

    public Player(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void changeCard(int index, Card card) {
        cards.remove(index);
        cards.add(card);
    }
}

