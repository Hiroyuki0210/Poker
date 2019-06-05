package play;

import java.util.ArrayList;
import java.util.Random;

	public class Card {

		ArrayList<Integer> card = new ArrayList<Integer>();

		//52枚のカード(ここではマークを区別しない)を山札にセットするコンストラクタ
		public Card(){
			ArrayList<Integer> card = new ArrayList<Integer>();

			for(int i=0; i<4; i++) {
				for(int j=1; j<=13; j++) {
					card.add(j);
				}
			}
			this.card = card;
		}

		//確認用なので実装しない
		public int v() {
			return card.size();
		}

		//カードをランダムに1枚配るメソッド
		public CardDetail deal() {
			Random rand = new Random();
			int ind = rand.nextInt(card.size());

			CardDetail cd = new CardDetail();
			cd.setNum(ind);
			cd.setType(ind);

			card.remove(ind);   //配り終わったカードを山札から外す

			return cd;
		}

		public ArrayList<Integer> restCard(){
			return card;
		}

	}

