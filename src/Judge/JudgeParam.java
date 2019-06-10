package Judge;

import java.util.List;

import card.Card;
import card.Suit;


//Judgeクラスで用いる変数をセット、取得する
public class JudgeParam {
	private int max ;
	private Suit suit;
	private int num ;
	private List<Card> pairnum;

	public JudgeParam(int max, Suit suit) {
		this.max = max;
		this.suit = suit;
	}

	public JudgeParam(int num, List<Card> pairnum) {
		this.num = num;
		this.pairnum = pairnum;
	}

	public int getMaxNum() {
		return max;
	}

	public Suit getMaxSuit() {
		return suit;
	}

	public int getNum() {
		return num;
	}

	public List<Card> getPairNum() {
		return pairnum;
	}

}