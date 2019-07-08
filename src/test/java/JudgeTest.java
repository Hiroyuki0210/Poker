package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import card.Card;
import card.Suit;
import judge.Judgement;

class JudgeTest {

	List<Card> hand = new ArrayList<>();

	@Test
	void straight() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,3));
		hand.add(new Card(Suit.CLOVER,4));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.CLOVER,6));
		assertEquals(Judgement.result(hand),"ストレート");
	}

	@Test
	void flash() {
		for(int i=0; i <5 ; i++) {
			hand.add(new Card(Suit.SPADE,i*2));
		}
		assertEquals(Judgement.result(hand),"フラッシュ");
	}

	@Test
	void straightflash() {
		for(int i=0; i <5 ; i++) {
			hand.add(new Card(Suit.SPADE,i+1));
		}
		assertEquals(Judgement.result(hand),"ストレートフラッシュ");
	}

	@Test
	void royalstraightflash() {
		int ind = 10;
		for(int i=0; i <5 ; i++) {
			if(ind == 14) {
				ind = 1;
			}
			hand.add(new Card(Suit.SPADE,ind));
			ind++;
		}
		assertEquals(Judgement.result(hand),"ロイヤルストレートフラッシュ");
	}

	@Test
	void pair() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,5));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),"2ペア");
	}

	@Test
	void card() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.SPADE,5));
		hand.add(new Card(Suit.SPADE,8));
		assertEquals(Judgement.result(hand),"3カード");
	}

	@Test
	void fullhouse() {
		hand.add(new Card(Suit.SPADE,2));
		hand.add(new Card(Suit.HEART,2));
		hand.add(new Card(Suit.CLOVER,2));
		hand.add(new Card(Suit.SPADE,8));
		hand.add(new Card(Suit.HEART,8));
		assertEquals(Judgement.result(hand),"フルハウス");
	}


}
