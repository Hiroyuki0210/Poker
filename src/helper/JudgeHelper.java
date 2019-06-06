package helper;

import java.util.ArrayList;

import card.Card;

public class JudgeHelper {
	private int count = 0;
	private ArrayList<Card> num;

	public int getMatchCount() {
		return count;
	}

	public void setMatchCount(int count) {
		this.count = count;
	}

	public ArrayList<Card> getMatchNum() {
		return num;
	}
	public void setMatchNum(ArrayList<Card> num) {
		this.num = num;
	}
}