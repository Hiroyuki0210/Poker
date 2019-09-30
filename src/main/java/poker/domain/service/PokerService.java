package poker.domain.service;

import poker.domain.model.Card;
import poker.domain.model.Deck;
import poker.domain.model.Player;
import poker.domain.model.hand.Hand;
import poker.domain.model.HandComparator;
import poker.domain.service.PlayerHandDetail;

import java.util.List;
import java.util.ArrayList;

//全プレイヤーの共通機能を持つ
public class PokerService {

	private Deck deck;
	private int numberOfComputer;
	private List<Player> players;
	private Player targetPlayer;


	public PokerService(int numberOfComputer) {
		this.numberOfComputer = numberOfComputer;
	}

	public void initialize() {
		deck = new Deck();
		List<Player> players = new ArrayList<>();

		//プレイヤーとコンピュータの初期状態
		for (int i = 0; i <= numberOfComputer; i++) {
			List<Card> playerCards = deck.draw(5);
			Player player = new Player(playerCards, i);
			players.add(player);
		}

		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void chooseTargetPlayer(Player targetPlayer){
		this.targetPlayer = targetPlayer;
	}

	public int getNumberOfComputer(){
		return numberOfComputer;
	}


	//手札の詳細(カードと役)
	public PlayerHandDetail getPlayerHand() {
		List<Card> cards = targetPlayer.getCards();
		Hand hand = Hand.getHand(cards);

		return new PlayerHandDetail(cards, hand);
	}

	//プレイヤーのカード交換
	public void exchangeCard(int[] indices) {
		List<Card> newCards = deck.draw(indices.length);

		targetPlayer.changeCard(indices, newCards);
	}

	/**
	 * プレイヤーの順位
	 * 戻り値には、手札が強いプレイヤーを順に格納する。
	 */
	public List<Player> result() {
		players.sort(new HandComparator());

		return players;
	}
	
}
