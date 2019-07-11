package judge;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.Suit;
import player.PlayerHand;


/** 役を判定するクラス(ポーカーの役は英語でhandだが、ここでは手札でhandを用いているので
 *  混同しないようにクラス名をYakuとしている)
 *  このクラスを使用する前提として、手札のカードが小さい順に並んでいる
 */
public class Yaku {
	//フィールド
	List<Card> hand;

	//コンストラクタ
	public Yaku(List<Card> hand){
		//手札枚数が5枚でない場合の例外処理
		if(hand.size()!= 5){
			throw new IllegalArgumentException("現在の手札枚数は"+hand.size()+"枚です。5枚にしてください。");
		}
		//トランプのカード数字が1~13でないorスートが指定されていない場合の例外処理
		for(Card ca : hand){
			if(!(1 <= ca.getNum() && ca.getNum() <= 13) || ca.getSuit() == null){
					throw new IllegalArgumentException("数字もしくはスートが不正なカードがあります。");
			}
		}
		this.hand = hand;
	}

	//ポーカーでは基本的にA(数字だと1)はK(13)より強いので、Aを14としておく(特例があるので、そのときに1と戻す)。
	public void changeA(){
		for(int i=0; i < hand.size(); i++) {
			if(hand.get(i).getNum() == 1){
				hand.set(i, new Card(hand.get(i).getSuit(), 14));
			}
		}
		//手札のカードを数字の小さい順に並べる
		PlayerHand.sort(hand);
	}


	//Aを14から1に戻す
	public void returnA(){
		for(int i=0; i < hand.size(); i++) {
			if(hand.get(i).getNum() == 14){
				hand.set(i, new Card(hand.get(i).getSuit(), 1));
			}
		}
		PlayerHand.sort(hand);
	}

	//ストレートの判定。手札の数字(5つすべて)が連続するか判定(連続する場合は手札内の最大値、連続しない場合は0を返す)
	public JudgeParam straight() {
		//手札の最大値
		int max = 0;
		//最大値(max)をとるカードのスート
		Suit su = null;

		boolean flag1 = false;
		boolean flag2 = false;

		//特例として、A2345（ここでは2345Aの順番）はストレートとみなせる
		for(int i=0; i < hand.size()-1; i++){
			if(hand.get(i).getNum() == i+2  &&  hand.get(hand.size()-1).getNum()==14) {
				flag1 = true;
			}else{
				flag1 = false;
				break;
			}
		}
		//手札が 2345A のとき、最も大きい数字は5なので、この情報を格納
		if(flag1) {
			max = hand.get(hand.size()-2).getNum();
			su = hand.get(hand.size()-2).getSuit();
		}

		//通常のストレートの判定
		for(int i=0; i < hand.size()-1; i++){
			if(hand.get(i+1).getNum() - hand.get(i).getNum() == 1) {
				flag2 = true;
			}else{
				flag2 = false;
				break;
			}
		}
		if(flag2) {
			max = hand.get(hand.size()-1).getNum();
			su = hand.get(hand.size()-1).getSuit();
		}
		return   new JudgeParam(max, su);
	}


	//フラッシュの判定。手札のすべてのスートが同じ場合1を返し、それ以外の場合0を返す
	public int flash() {
		int num = 0;
		boolean flag = true;

		for(int i = 1; i< hand.size() && flag; i++){
			if(hand.get(i).getSuit() != hand.get(0).getSuit()){
				flag = false;
			}
		}
		if(flag){
			num = 1;
		}
		return num;
	}


	//ペアとカード(3カードなど)の判定。ペアになったカードに関する情報を格納
	public JudgeParam pair() {
		/*ペアになったカードを格納するための配列(カード番号が重複するものは入れない&スートが最も強いものだけ格納)
		 * ex: ♥3♦3♠3♠4♦5
		 * 3のペアになっており、この中で最も強いスートは♠なのでpairnumには♠3を格納
		 */
		List<Card> paircard = new ArrayList<>();
		 //最大重複枚数(ex: 手札が 22345 ならば num=2、 33344 ならば num=3)
		int num  = 0;

		//ペアになったカードを格納
		for(int i=0; i<hand.size()-1; i++){
			if(hand.get(i+1).getNum() == hand.get(i).getNum()) {
				num = 2;
				paircard.add(hand.get(i+1));
			}
		}

		//最大重複枚数が3枚以上のとき(ex: 22234)のnumに関する処理
		for(int i=0; i<paircard.size()-1;i++) {
			if(paircard.get(i).getNum() == paircard.get(i+1).getNum()) {
				num++;
			}
		}

		//pairnumの要素から重複を省く
		if(num >= 3) {
			for(int i=0; i < num-2; i++) {
				paircard.remove(i);
			}
		}
		return new JudgeParam(num, paircard);
	}

}