package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import card.Card;
import card.Deck;

//プレイヤーの手札に関する機能
public class PlayerHand {
	//手札の並び替え
	public static void sort(List<Card> hand) {
		// Comparatorを実装した匿名クラス
		Comparator<Card> comparator = new Comparator<Card>() {
			public int compare(Card c1, Card c2) {
				return c1.getNum() < c2.getNum() ? -1 : 1;
			}
		};
		Collections.sort(hand, comparator);
	}

	//カードの交換
	public static void changeCard(List<Card> hand, Deck deck, String[] changenum) {
		List<Card> set = new ArrayList<>();

		//削除するカードのを番号をsetに格納
		for(int i=0; i < changenum.length; i++){
    		Collections.addAll(set, hand.get(Integer.parseInt(changenum[i])));
    		hand.add(deck.draw());
    	}
		//指定番号のカードを一度に全て削除
		hand.removeAll(set);
	}
}
