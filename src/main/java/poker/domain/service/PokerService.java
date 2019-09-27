package poker.domain.service;

import poker.domain.model.Card;
import poker.domain.model.Deck;
import poker.domain.model.Player;
import poker.domain.model.hand.Hand;
import poker.domain.model.HandComparator;
import poker.domain.service.PlayerHandDetail;

import java.util.List;
import java.util.ArrayList;


public class PokerService {

	private Deck deck;
	private int numberOfComputer;
	private List<Player> players;

	public PokerService(int numberOfComputer) {
		this.numberOfComputer = numberOfComputer;
	}

	public void initialize() {
		deck = new Deck();
		List<Player> players = new ArrayList<>();

		//プレイヤーの初期状態
		List<Card> playrCards = deck.draw(5);
		Player player = new Player(playrCards, "プレイヤー");
		players.add(player);

		//コンピュータの初期状態
		for (int i = 0; i < numberOfComputer; i++) {
			List<Card> ComputerCards = deck.draw(5);
			Player computer = new Player(ComputerCards, "コンピュータ" + (i+1));
			players.add(computer);
		}
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public PlayerHandDetail getPlayerHand(Player player) {
		List<Card> cards = player.getCards();
		Hand hand = Hand.getHand(cards);

		return new PlayerHandDetail(cards, hand);
	}

	//プレイヤーのカード交換
	public void exchangeCard(int[] indices, Player player) {
		List<Card> newCards = deck.draw(indices.length);

		player.changeCard(indices, newCards);
	}

	/**
	 * コンピュータの自動カード交換
	 * Nothing以外の役が出るまでカード交換する。
	 */
	public void autoExchangeCard(Player computer) {
		List<Card> computerCard = computer.getCards();
		if (Hand.getHand(computerCard).getHandRank() == 9) {
			int[] changeCards = {0,1,2};
			List<Card> newCards = deck.draw(3);

			computer.changeCard(changeCards, newCards);
		}
	}

	//各コンピュータの手札の役がnothingか否かの判定
	public boolean completeHand(Player computer) {
		boolean COMPLETE_HAND = false;
		List<Card> computerCards = computer.getCards();
		PlayerHandDetail handDetail = new PlayerHandDetail(computerCards, Hand.getHand(computerCards));
		int computerHandRank = handDetail.getHand().getHandRank();
		String computerName = computer.getName();

		if  (computerName.contains("コンピュータ") && computerHandRank == 9) {
			return false;
		}

		if (computerName.equals("コンピュータ" + numberOfComputer) && computerHandRank != 9) {
			COMPLETE_HAND = true;
		}

		return COMPLETE_HAND;
	}

	/**
	 * プレイヤーの順位
	 * 戻り値には、手札が強いプレイヤーを順に格納する。
	 */
	public List<Player> result(List<Player> players) {
		players.sort(new HandComparator());

		return players;
	}
	
}
