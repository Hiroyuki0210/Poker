package Judge;

import java.util.ArrayList;

import card.Card;
import helper.JudgeHelper;

//このクラスを使用する前提として、手札のカードが小さい順に並んでいる(Sortクラスのsortメソッドを用いている)
public class Judge {

	//ポーカーでは基本的にA(数字だと1)はK(13)より強いので、Aを14としておく(特例があるので、そのときに1と戻す)。
	public Judge(ArrayList<Card> hand){
		for(int i=0; i < hand.size(); i++) {
			if(hand.get(i).getNum() == 1){
				hand.set(i, new Card(hand.get(i).getSuit(), 14));
			}
		}
	}

	//手札の数字(5つすべて)が連続するか判定(連続する場合は手札内の最大値、連続しない場合は0を返す)
	public int continuous(ArrayList<Card> hand) {
		int con = 0;

		//ポーカーの役で、A2345はストレートとみなせるので、この場合はAを1とみなす。
		for(int i=1; i < hand.size(); i++){
			if(hand.get(i).getNum() == i+1) {
				hand.set(1, new Card(hand.get(1).getSuit(), 1));
			}
		}

		//
		for(int i=0; i < hand.size()-1; i++){
			if(hand.get(i+1).getNum() - hand.get(i).getNum() == 1) {
				con = hand.get(hand.size()).getNum();
			}
		}

		return con;
	}

	//手札で数字が一致したカードに関する情報を格納(numの要素数によって、一致したカードがあるか判断)
	public JudgeHelper match(ArrayList<Card> hand) {
		ArrayList<Card> num = new ArrayList<Card>();
		int count = 2;

		//2つ以上数字が同じになったカードをnumに格納(3つ以上同じになったら、同じ数字が2つ以上num格納されるがこの後でそれを削除)
		for(int i=0; i<hand.size()-1; i++ ) {
			if(hand.get(i+1).getNum() - hand.get(i).getNum() == 0) {
				num.add(hand.get(i));
			}
		}

		//数字が同じになったカードセットに関して、1セット当たりの枚数(count)/countが3以上の場合numには同じ数字が2つ以上格納されてしまうのでダブった数字を削除
		if(num.size() >= 2) {
			for(int i=0; i<num.size()-1;i++) {
				if(num.get(i).getNum() == num.get(i+1).getNum()) {
					count++;
					num.remove(i+1);
				}
			}
		}

		JudgeHelper jh = new JudgeHelper();
		jh.setMatchCount(count);
		jh.setMatchNum(num);

		return jh;


	}


}
