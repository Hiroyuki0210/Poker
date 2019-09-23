package poker.domain.service;

import poker.domain.model.Card;
import poker.domain.model.Deck;
import poker.domain.model.Player;
import poker.domain.model.hand.Hand;

import java.util.List;


public class PokerService {

	private Deck deck;
	private Player player;

	public void initialize() {
		deck = new Deck();
		List<Card> cards = deck.draw(5);
		player = new Player(cards);
	}

	public PlayerHandDetail getPlayerHand() {
		List<Card> cards = player.getCards();
		Hand hand = Hand.getHand(cards);

		return new PlayerHandDetail(cards, hand);
	}

	//カード交換
	public void exchangeCard(int[] indices) {
		List<Card> newCards = deck.draw(indices.length);

		player.changeCard(indices, newCards);
	}
}
