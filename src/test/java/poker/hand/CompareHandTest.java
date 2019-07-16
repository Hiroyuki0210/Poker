package poker.hand;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import poker.hand.hand.Hand;

//役の強さのテスト
public class CompareHandTest {

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
	public void compareStraightFlushAndRoyalStraightFlush() {
		for(int i=2; i <=6 ; i++) {
			hand1.add(new Card(Suit.SPADE,i));
		}

		hand2.add(new Card(Suit.HEART,1));
		for(int i=10; i <=13 ; i++) {
			hand2.add(new Card(Suit.HEART,i));
		}

		Hand h1 = Hand.getHand(hand1);
		Hand h2 = Hand.getHand(hand2);

		assertThat(h1, lessThan(h2));
	}

	@Test
	public void compareFourOfAKindAndStraightFlush() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,2));
		hand1.add(new Card(Suit.CLOVER,2));
		hand1.add(new Card(Suit.DIAMOND,2));
		hand1.add(new Card(Suit.SPADE,8));

		for(int i=3; i <=7 ; i++) {
			hand2.add(new Card(Suit.SPADE,i));
		}

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareFullHouseAndFourOfAKind() {
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
		
		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareFlushAndFullHouse() {
		for(int i=1; i <10 ; i += 2) {
			hand1.add(new Card(Suit.SPADE,i));
		}

		hand2.add(new Card(Suit.SPADE,2));
		hand2.add(new Card(Suit.HEART,2));
		hand2.add(new Card(Suit.CLOVER,2));
		hand2.add(new Card(Suit.SPADE,8));
		hand2.add(new Card(Suit.HEART,8));

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareStraightAndFlush() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,3));
		hand1.add(new Card(Suit.CLOVER,4));
		hand1.add(new Card(Suit.SPADE,5));
		hand1.add(new Card(Suit.CLOVER,6));

		for(int i=1; i <10 ; i += 2) {
			hand2.add(new Card(Suit.CLOVER,i));
		}

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareThreeOfAKindAndStraight() {
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

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareTwoPairAndThreeOfAKind() {
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

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareOnePairAndTwoPair() {
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

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}

	@Test
	public void compareNothingAndOnePair() {
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

		assertThat(Hand.getHand(hand1), lessThan(Hand.getHand(hand2)));
	}
}