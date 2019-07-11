package judge;

import java.util.List;

import card.Card;
import card.Suit;


//Judgeクラスで用いる変数をセット、取得する
public class JudgeParam {
	private int straightMax ;
	private Suit straightSuit;
	private int num ;
	private List<Card> paircard;

	public JudgeParam(int straightMax, Suit straightSuit) {
		this.straightMax = straightMax;
		this.straightSuit = straightSuit;
	}

	public JudgeParam(int num, List<Card> paircard) {
		this.num = num;
		this.paircard = paircard;
	}

	public int getMaxNum() {
		return straightMax;
	}

	public Suit getMaxSuit() {
		return straightSuit;
	}

	public int getNum() {
		return num;
	}

	public List<Card> getPairCard() {
		return paircard;
	}

}