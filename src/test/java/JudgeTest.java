package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import card.Card;
import card.Suit;
import judge.Judgement;
import judge.PokerHand;

//10種類の役のテスト
class JudgeTest {

	List<Card> hand = new ArrayList<>();

	@Test
	void straight() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,3));
		hand.add(new Card(Suit.CLOVER,4));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.CLOVER,6));
		assertEquals(Judgement.result(hand),PokerHand.STRAIGHT.getName());
	}

	@Test
	void flash() {
		for(int i=0; i <5 ; i += 2) {
			hand.add(new Card(Suit.SPADE,i));
		}
		assertEquals(Judgement.result(hand),PokerHand.FLASH.getName());
	}

	@Test
	void straightflash() {
		for(int i=1; i <=5 ; i++) {
			hand.add(new Card(Suit.SPADE,i));
		}
		assertEquals(Judgement.result(hand),PokerHand.STRAIGHTFLASH.getName());
	}

	@Test
	void royalstraightflash() {
		hand.add(new Card(Suit.SPADE,1));
		for(int i=10; i <=13 ; i++) {
			hand.add(new Card(Suit.SPADE,i));
		}
		assertEquals(Judgement.result(hand),PokerHand.ROYALSTRAIGHTFLASH.getName());
	}

	@Test
	void twoPair() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,5));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.TWOPAIR.getName());
	}

	@Test
	void onewPair() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,5));
		hand.add(new Card(Suit.SPADE,6));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.ONEPAIR.getName());
	}

	@Test
	void threeCard() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.THREECARD.getName());
	}

	@Test
	void fourCard() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.DIAMOND,2));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),PokerHand.FOURCARD.getName());
	}

	@Test
	void fullhouse() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.SPADE,8));
		hand.add(new Card(Suit.HEART,8));
		assertEquals(Judgement.result(hand),PokerHand.FULLHOUSE.getName());
	}

	@Test
	void nothing() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,4));
		hand.add(new Card(Suit.CLOVER,7));
		hand.add(new Card(Suit.SPADE,8));
		hand.add(new Card(Suit.HEART,10));
		assertEquals(Judgement.result(hand),PokerHand.NOTHING.getName());
	}


}