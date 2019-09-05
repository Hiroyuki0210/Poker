package poker.domain.service;

import poker.domain.model.Deck;
import poker.domain.model.Player;
import poker.domain.model.hand.Hand;

public class PokerService {
    private Deck deck;
    private Player player;

    public PokerService() {}

    public void initialize() {
        deck = new Deck();
        var cards = deck.draw(5);
        player = new Player(cards);
    }

    public PlayerHandDetail getPlayerHand() {
        var cards = player.getCards();
        var hand = Hand.getHand(cards);

        return new PlayerHandDetail(cards, hand);
    }

    public void changeCard(int... indexes) {
        var newCards = deck.draw(indexes.length);

        for (int i = 0; i < indexes.length; i++) {
            player.changeCard(indexes[i], newCards.get(i));
        }
    }
}
