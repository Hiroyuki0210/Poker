package Judge;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Suit;

//このクラスを使用する前提として、手札のカードが小さい順に並んでいる
public class Judge {

	//ポーカーでは基本的にA(数字だと1)はK(13)より強いので、Aを14としておく(特例があるので、そのときに1と戻す)。
	public void changeA(List<Card> hand){
		for(int i=0; i < hand.size(); i++) {
			if(hand.get(i).getNum() == 1){
				hand.set(i, new Card(hand.get(i).getSuit(), 14));
			}
		}
		Card ca = new Card(null,0);
		ca.sort(hand);                      //数字の小さい順に並べる
	}


	//Aを14から1に戻す
	public void returnA(List<Card> hand){
		for(int i=0; i < hand.size(); i++) {
			if(hand.get(i).getNum() == 14){
				hand.set(i, new Card(hand.get(i).getSuit(), 1));
			}
		}
		Card ca = new Card(null,0);
		ca.sort(hand);                      //数字の小さい順に並べる
	}


	//手札の数字(5つすべて)が連続するか判定(連続する場合は手札内の最大値、連続しない場合は0を返す)
	public JudgeParam straight(List<Card> hand) {
		int max = 0;
		Suit su = null;
		Card ca = new Card(null,0);
		List<String> kaku = new ArrayList<String>();

		//ポーカーの役で、A2345（ここでは2345Aの順番）はストレートとみなせるので、この場合はAを1とみなす。
		for(int i=0; i < hand.size()-1; i++){
			if(hand.get(i).getNum() == i+2  &&  hand.get(hand.size()-1).getNum()==14 ) {
				kaku.add("");
			}
		}
		if(kaku.size() == hand.size()-1) {
			hand.set(hand.size()-1, new Card(hand.get(hand.size()-1).getSuit(), 1));
			ca.sort(hand);
			kaku = new ArrayList<>();
		}

		//連続する場合、最大値をとるカードの数とスートを格納
		for(int i=0; i < hand.size()-1; i++){
			if(hand.get(i+1).getNum() - hand.get(i).getNum() == 1) {
				kaku.add("");
			}
		}
		if(kaku.size() == hand.size()-1) {
			max = hand.get(hand.size()-1).getNum();
			su = hand.get(hand.size()-1).getSuit();
		}

		return   new JudgeParam(max, su);
	}


	//手札のすべてのスートが同じかどうか確認
	public int flash(List<Card> hand) {
		int num = 0;
		boolean flag = true;

	    for(int i = 1; i< hand.size() && flag; i++)
	    {
	        if(hand.get(i).getSuit() != hand.get(0).getSuit()){
	        	flag = false;
	        }
	    }
	    if(flag){
	    	num = 1;
	    }
		return num;
	}


	//ペアになったカードに関する情報を格納
	public JudgeParam pair(List<Card> hand) {
		List<Card> pairnum = new ArrayList<>();             //ペアになった番号を格納(重複しない)
		int  num = 0;                                       //ペアカードの最大枚数(ex: 手札が 22345 ならば num=2、 33344 ならば num=3)
		//JudgeParam jp = new JudgeParam();

		//ペアになったカードを格納(この時点では重複する)
		for(int i=0; i<hand.size()-1; i++ ) {
			if(hand.get(i+1).getNum() - hand.get(i).getNum() == 0) {
				num = 2;
				pairnum.add(hand.get(i));
			}
		}

		//重複枚数が3枚以上のときのnumに関する処理
			for(int i=0; i<pairnum.size()-1;i++) {
				if(pairnum.get(i).getNum() == pairnum.get(i+1).getNum()) {
					num++;
				}
			}

		//重複を省く
			if(num >= 3) {
				for(int i=0; i < num-2; i++) {
					pairnum.remove(i);
				}
			}

		return new JudgeParam(num, pairnum);

	}

}
