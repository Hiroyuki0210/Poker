package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.Suit;
import judge.Judgement;

//役の強さのテスト
public class YakuStrengthTest {

	List<Card> hand1 = new ArrayList<>();
	List<Card> hand2 = new ArrayList<>();

/**以下のメソッドは2つの役の強さを比較するテストです。
 * 比較する役同士は1段階だけ異なります。
 * (ex)　ストレートフラッシュ VS ロイヤルストレートフラッシュ
 * 各メソッド名には2つの役が出てきます。
 * 1つ目の役がhand1、2つ目の役がhand2に対応しています。
 * (ex) straigtflashVsRoyalstraightflash　→　hand1はストレートフラッシュの状態、hand2はロイヤルストレートフラッシュの状態
 *  */

	@Test
	public void straigtflashVsRoyalstraightflash() {
		for(int i=2; i <=6 ; i++) {
			hand1.add(new Card(Suit.SPADE,i));
		}

		hand2.add(new Card(Suit.HEART,1));
		for(int i=10; i <=13 ; i++) {
			hand2.add(new Card(Suit.HEART,i));
		}

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void fourcardVsStraightflash() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,2));
		hand1.add(new Card(Suit.CLOVER,2));
		hand1.add(new Card(Suit.DIAMOND,2));
		hand1.add(new Card(Suit.SPADE,8));

		for(int i=3; i <=7 ; i++) {
			hand2.add(new Card(Suit.SPADE,i));
		}

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void fullhouseVsFourcard() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,2));
		hand1.add(new Card(Suit.CLOVER,2));
		hand1.add(new Card(Suit.SPADE,8));
		hand1.add(new Card(Suit.HEART,8));

		hand2.add(new Card(Suit.SPADE,3));
		hand2.add(new Card(Suit.HEART,3));
		hand2.add(new Card(Suit.CLOVER,3));
		hand2.add(new Card(Suit.DIAMOND,3));
		hand2.add(new Card(Suit.SPADE,10));
		
		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void flashVsFullhouse() {
		for(int i=1; i <10 ; i += 2) {
			hand1.add(new Card(Suit.SPADE,i));
		}

		hand2.add(new Card(Suit.SPADE,2));
		hand2.add(new Card(Suit.HEART,2));
		hand2.add(new Card(Suit.CLOVER,2));
		hand2.add(new Card(Suit.SPADE,8));
		hand2.add(new Card(Suit.HEART,8));

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void straightVsFlash() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,3));
		hand1.add(new Card(Suit.CLOVER,4));
		hand1.add(new Card(Suit.SPADE,5));
		hand1.add(new Card(Suit.CLOVER,6));

		for(int i=1; i <10 ; i += 2) {
			hand2.add(new Card(Suit.CLOVER,i));
		}

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void threecardVsStraight() {
		hand1.add(new Card(Suit.SPADE,9));
		hand1.add(new Card(Suit.HEART,9));
		hand1.add(new Card(Suit.CLOVER,9));
		hand1.add(new Card(Suit.SPADE,11));
		hand1.add(new Card(Suit.SPADE,12));

		hand2.add(new Card(Suit.SPADE,2));
		hand2.add(new Card(Suit.HEART,3));
		hand2.add(new Card(Suit.CLOVER,4));
		hand2.add(new Card(Suit.SPADE,5));
		hand2.add(new Card(Suit.CLOVER,6));

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void twopairVsThreecard() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,2));
		hand1.add(new Card(Suit.CLOVER,5));
		hand1.add(new Card(Suit.SPADE,5));
		hand1.add(new Card(Suit.SPADE,8));

		hand2.add(new Card(Suit.SPADE,4));
		hand2.add(new Card(Suit.HEART,4));
		hand2.add(new Card(Suit.CLOVER,4));
		hand2.add(new Card(Suit.SPADE,9));
		hand2.add(new Card(Suit.SPADE,10));

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void onepairVsTwopair() {
		hand1.add(new Card(Suit.SPADE,4));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.HEART,5));
		hand1.add(new Card(Suit.SPADE,7));
		hand1.add(new Card(Suit.SPADE,8));

		hand2.add(new Card(Suit.SPADE,2));
		hand2.add(new Card(Suit.HEART,2));
		hand2.add(new Card(Suit.CLOVER,5));
		hand2.add(new Card(Suit.SPADE,5));
		hand2.add(new Card(Suit.DIAMOND,8));

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

	@Test
	public void nothingVsOnepair() {
		hand1.add(new Card(Suit.DIAMOND,2));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.CLOVER,7));
		hand1.add(new Card(Suit.DIAMOND,8));
		hand1.add(new Card(Suit.HEART,10));

		hand2.add(new Card(Suit.SPADE,2));
		hand2.add(new Card(Suit.HEART,2));
		hand2.add(new Card(Suit.CLOVER,5));
		hand2.add(new Card(Suit.SPADE,7));
		hand2.add(new Card(Suit.SPADE,8));

		assert Judgement.result(hand1).getStrength() < Judgement.result(hand2).getStrength();
	}

}