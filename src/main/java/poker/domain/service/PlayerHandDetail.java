package poker.domain.service;

import poker.domain.model.Card;
import poker.domain.model.hand.Hand;

import java.util.List;

public class PlayerHandDetail {
    private final List<Card> cards;
    private final Hand hand;

    public PlayerHandDetail(List<Card> cards, Hand hand) {
        this.cards = cards;
        this.hand = hand;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Hand getHand() {
        return hand;
    }
}
