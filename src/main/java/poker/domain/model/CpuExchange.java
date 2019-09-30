package poker.domain.model;

import java.util.*;

import poker.domain.model.hand.Hand;
import poker.domain.model.PlayerName;
import poker.domain.service.PlayerHandDetail;


//CPUの手札交換に関するメソッド
public class CpuExchange {

	//交換するカードのインデックス
	public int[] getIndices(Player computer) {
     	List<Card> cards = computer.getCards();
     	if (Hand.getHand(cards).getHandRank() == 9) {
          	int[] changeCards = { 0, 1, 2 };
          	return changeCards;
        	} else {
          	return null;
     	}
	}

    //各コンピュータの手札の役がnothingか否かの判定
	public boolean completeHand(Player computer, int numberOfComputer) {
		boolean COMPLETE_HAND = false;
		List<Card> computerCards = computer.getCards();
		PlayerHandDetail handDetail = new PlayerHandDetail(computerCards, Hand.getHand(computerCards));

		int computerHandRank = handDetail.getHand().getHandRank();
		String computerName = computer.getName();
		
		String lastPlayerName = "";
	
		for (PlayerName playerName : PlayerName.values()) {
			if (playerName.getIndex() == numberOfComputer) {
				lastPlayerName = playerName.getName();
			}

			if  (computerName.equals(playerName.getName()) && computerHandRank == 9) {
				return false;
			}
		}

		if (computerName.equals(lastPlayerName) && computerHandRank != 9) {
			COMPLETE_HAND = true;
		}
		
		return COMPLETE_HAND;
	}

}