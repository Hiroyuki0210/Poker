package classproject;

import java.util.ArrayList;
import java.util.Random;

class Dealer extends player {
		protected ArrayList<Integer> cards = new ArrayList<Integer>();

		/*13枚×4=52枚の山札の作成*/
		public Dealer() {
			ArrayList<Integer> Cards = new ArrayList<Integer>();
			for(int i=1; i<=4; i++) {
				for(int j =1; j<=13; j++) {
					Cards.add(j);
				}
			}
			this.cards = Cards;
		}

		public ArrayList<Integer> deal(){
			/*初めにuserまたはdealerに配られるトランプ配列(名前:Deals、要素数:2つ)を作成*/

			ArrayList<Integer> Deals = new ArrayList<Integer>();
			Random rand1 = new Random();

			int index0 = rand1.nextInt(cards.size());

			for(int i=0; i<2; i++) {
/*訂正*/		Deals.add(cards.get(index0));            //←前回までは乱数が入った配列を用いておりましたが、1つの変数に変えました。 //cards配列のランダム番目のカードを1枚配る)
				cards.remove(index0);                     //配られたカードを山札から消す
			}
			return Deals;
		}

		public ArrayList<Integer> hit(){
			ArrayList<Integer> Hit = new ArrayList<Integer>();
		    Random rand2 = new Random();

			int index = rand2.nextInt(cards.size()) ;
			Hit.add(cards.get(index));                         //hitでcards配列のランダム番目のカードを配る
			cards.remove(index);                               //hitで配られたカードを山札から消す

			return Hit;
		}

		/*手元にあるカードの合計値を計算する。ただし、11以上のカードは10としてカウント*/
		public int open(){
			int dealertotal = 0;
			for(int value: myCards) {
				if(value >= 11) {
					value = 10;
					dealertotal += value;
				}else {
				dealertotal += value;
				}
			}
			return dealertotal;
		}

		/*引数(もらうカード)を手札に加えていく*/
		public void setCard(ArrayList<Integer> dealerCards) {
               for(int i=0; i < dealerCards.size(); i++) {
				myCards.add(dealerCards.get(i));
			}
		}

		/*合計値が16以下の場合は引き続き引くようにする*/
		public boolean checkSum(){
/*訂正*/		if(open()<=16) {
				return true;
			}
			else {
				return false;
			}
		}

	}
