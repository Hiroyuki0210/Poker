package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//10種類の役のテスト
public class JudgeTest {

	List<Card> hand = new ArrayList<>();

	@Test
	public void straight_() {
		hand.add(new Card(Suit.CLOVER,1));
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,3));
		hand.add(new Card(Suit.CLOVER,4));
		hand.add(new Card(Suit.SPADE,5));
		assertEquals(Judgement.result(hand),PokerHand.STRAIGHT);
	}

	@Test
	public void straight() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,3));
		hand.add(new Card(Suit.CLOVER,4));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.CLOVER,6));
		assertEquals(Judgement.result(hand),PokerHand.STRAIGHT);
	}

	@Test
	public void flash() {
		for(int i=1; i <10 ; i += 2) {
			hand.add(new Card(Suit.SPADE,i));
		}
		assertEquals(Judgement.result(hand),PokerHand.FLASH);
	}

	@Test
	public void straightflash() {
		for(int i=1; i <=5 ; i++) {
			hand.add(new Card(Suit.SPADE,i));
		}
		assertEquals(Judgement.result(hand),PokerHand.STRAIGHTFLASH);
	}

	@Test
	public void royalstraightflash() {
		hand.add(new Card(Suit.SPADE,1));
		for(int i=10; i <=13 ; i++) {
			hand.add(new Card(Suit.SPADE,i));
		}
		assertEquals(Judgement.result(hand),PokerHand.ROYALSTRAIGHTFLASH);
	}

	@Test
	public void twoPair() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,5));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.TWOPAIR);
	}

	@Test
	public void onewPair() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,5));
		hand.add(new Card(Suit.SPADE,6));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.ONEPAIR);
	}

	@Test
	public void threeCard() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.THREECARD);
	}

	@Test
	public void fourCard() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.DIAMOND,2));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.FOURCARD);
	}

	@Test
	public void fullhouse() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.SPADE,8));
		hand.add(new Card(Suit.HEART,8));
		assertEquals(Judgement.result(hand),PokerHand.FULLHOUSE);
	}

	@Test
	public void nothing() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,4));
		hand.add(new Card(Suit.CLOVER,7));
		hand.add(new Card(Suit.SPADE,8));
		hand.add(new Card(Suit.HEART,10));
		assertEquals(Judgement.result(hand),PokerHand.NOTHING);
	}
}