package poker.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//プレイヤーの手札に関する機能
public class PlayerHand {

	//手札の並び替え(数字の小さい順、数字が同じ場合スートの弱い順)
	public static void sort(List<Card> hand) {
		//Comparatorを実装した匿名クラス
		Comparator<Card> comparator = new Comparator<Card>() {
			public int compare(Card c1, Card c2) {
				int a = c1.getNum() - c2.getNum();
				if(a == 0) {
					return c1.getSuit().strength - c2.getSuit().strength;
				}
				return a;
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