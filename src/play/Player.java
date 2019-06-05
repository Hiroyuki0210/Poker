package play;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
//抽象クラス ・・・ カードを交換するメソッド、
/*abstract class Player {
	//abstract public void setCard(ArrayList<Integer> set);
	//abstract public void change();
}
*/


public class Player {
	private ArrayList<Integer> cards = new ArrayList<Integer>();
	HashMap<String,ArrayList<Integer>> type = new HashMap<String, ArrayList<Integer>>();

	//山札にそれぞれのマーク(スペード、クローバ、ハート、ダイヤ)を識別する52枚のカードをセットする
	public void set() {
		ArrayList<Integer> card = new ArrayList<Integer>();
		HashMap<String,ArrayList<Integer>> type = new HashMap<String, ArrayList<Integer>>();

		for(int i=0; i<4; i++) {
			for(int j=1; j<=13; j++) {
				card.add(j);
			}
		}
		ArrayList<Integer> group1 = new ArrayList<Integer>();
		ArrayList<Integer> group2 = new ArrayList<Integer>();
		ArrayList<Integer> group3 = new ArrayList<Integer>();
		ArrayList<Integer> group4 = new ArrayList<Integer>();

		for(int i=0; i<13; i++) {
			group1.add(card.get(i));
			type.put("スペード", group1);
		}

		for(int i=13; i<26; i++) {
			group2.add(card.get(i));
			type.put("クローバ", group2);
		}
		for(int i=26; i<39; i++) {
			group3.add(card.get(i));
			type.put("ハート", group3);
		}
		for(int i=39; i<52; i++) {
			group4.add(card.get(i));
			type.put("ダイヤ", group4);
		}

		this.cards = card;
		this.type = type;
	}

	//カードを配るメソッド
	public int deal () {
		int dealCard = 0;
		Random rand = new Random();
		int ind = rand.nextInt(cards.size());  //52枚の中からランダムにカードを選ぶ

		dealCard = cards.get(ind); //カードを配る
		cards.remove(ind); //配ったカードを山札から外す

		return dealCard;
	}

	public int write() {

		/*
		String cate = "";
		for(int i=0; i<13; i++) {
			if(cards.get(num) == type.get("スペード").get(i)){
			cate = "スペード";
			}
			else if(cards.get(num) == type.get("クローバ").get(i)){
				cate = "クローバ";
				}
			else if(cards.get(num) == type.get("ハート").get(i)){
				cate = "ハート";
				}
			else if(cards.get(num) == type.get("ダイヤ").get(i)){
				cate = "ダイヤ";
				}
			else {

			}
		}
		*/
		return  type.get("クローバ").size();
	}



/*	public setCard() {

	}
*/

}