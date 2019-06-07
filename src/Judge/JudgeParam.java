package Judge;

import java.util.List;

import card.Card;
import card.Suit;


//JudgeMaterialクラスで用いる変数をセット、取得する
public class JudgeParam {
	private int max = 0;
	private Suit suit;
	private int num = 0;
	private List<Card> pairnum;

	public int getMaxNum() {
		return max;
	}

	public void setMaxNum(int max) {
		this.max = max;
	}

	public Suit getMaxSuit() {
		return suit;
	}

	public void setMaxSuit(Suit suit) {
		this.suit = suit;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Card> getPairNum() {
		return pairnum;
	}
	public void setPairNum(List<Card> pairnum) {
		this.pairnum = pairnum;
	}

}