package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**役が同じだった場合、それぞれの手札カードの最大値で勝敗決定
 * 各メソッドでは、hand2が勝つように設定している
 * */

public class NumberStrengthTest {

	List<Card> hand1 = new ArrayList<>();
    List<Card> hand2 = new ArrayList<>();

	@Test
	public void sameStraightflash() {
		for(int i=1; i <=5 ; i++) {
			hand1.add(new Card(Suit.SPADE,i));
        }
        
		for(int i=2; i <=6 ; i++) {
			hand2.add(new Card(Suit.CLOVER,i));
        }
        
        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.STRAIGHTFLASH));
	}

	@Test
	public void sameFourcard() {
		hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,2));
		hand1.add(new Card(Suit.CLOVER,2));
		hand1.add(new Card(Suit.DIAMOND,2));
        hand1.add(new Card(Suit.SPADE,8));
        
        hand2.add(new Card(Suit.SPADE,5));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.CLOVER,5));
		hand2.add(new Card(Suit.DIAMOND,5));
		hand2.add(new Card(Suit.HEART,8));
		
		assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.FOURCARD));
    }


	@Test
	public void sameFullhouse() {
        hand1.add(new Card(Suit.SPADE,4));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.CLOVER,4));
		hand1.add(new Card(Suit.SPADE,8));
		hand1.add(new Card(Suit.HEART,8));

		hand2.add(new Card(Suit.SPADE,3));
		hand2.add(new Card(Suit.HEART,3));
		hand2.add(new Card(Suit.CLOVER,3));
		hand2.add(new Card(Suit.SPADE,10));
		hand2.add(new Card(Suit.HEART,10));

		assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.FULLHOUSE));
    }

    @Test
	public void sameFlash() {
        for(int i=2; i <11 ; i += 2) {
			hand1.add(new Card(Suit.SPADE,i));
		}

        hand2.add(new Card(Suit.HEART,3));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.HEART,8));
		hand2.add(new Card(Suit.HEART,9));
		hand2.add(new Card(Suit.HEART,12));
		

        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.FLASH));
    }

    @Test
	public void sameStraight() {
        hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,3));
		hand1.add(new Card(Suit.CLOVER,4));
		hand1.add(new Card(Suit.SPADE,5));
        hand1.add(new Card(Suit.CLOVER,6));
        
        hand2.add(new Card(Suit.SPADE,4));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.HEART,6));
		hand2.add(new Card(Suit.SPADE,7));
		hand2.add(new Card(Suit.CLOVER,8));
		

        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.STRAIGHT));
    }


    @Test
	public void sameThreecard() {
        hand1.add(new Card(Suit.SPADE,4));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.CLOVER,4));
		hand1.add(new Card(Suit.SPADE,6));
		hand1.add(new Card(Suit.CLOVER,8));

        hand2.add(new Card(Suit.SPADE,5));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.CLOVER,5));
		hand2.add(new Card(Suit.SPADE,7));
		hand2.add(new Card(Suit.SPADE,8));
		

        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.THREECARD));
    }

    @Test
	public void sameTwopair() {
        hand1.add(new Card(Suit.SPADE,4));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.CLOVER,6));
		hand1.add(new Card(Suit.SPADE,6));
		hand1.add(new Card(Suit.CLOVER,8));

        hand2.add(new Card(Suit.SPADE,5));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.CLOVER,7));
		hand2.add(new Card(Suit.SPADE,7));
		hand2.add(new Card(Suit.SPADE,8));
		

        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.TWOPAIR));
    }

    @Test
	public void sameOnepair() {
        hand1.add(new Card(Suit.SPADE,4));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.CLOVER,6));
		hand1.add(new Card(Suit.SPADE,8));
		hand1.add(new Card(Suit.CLOVER,13));

        hand2.add(new Card(Suit.SPADE,5));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.CLOVER,7));
		hand2.add(new Card(Suit.SPADE,9));
		hand2.add(new Card(Suit.SPADE,12));
		

        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.ONEPAIR));
    }

    @Test
	public void sameNothing() {
        hand1.add(new Card(Suit.SPADE,2));
		hand1.add(new Card(Suit.HEART,4));
		hand1.add(new Card(Suit.CLOVER,6));
		hand1.add(new Card(Suit.SPADE,8));
		hand1.add(new Card(Suit.CLOVER,11));

        hand2.add(new Card(Suit.SPADE,3));
		hand2.add(new Card(Suit.HEART,5));
		hand2.add(new Card(Suit.CLOVER,7));
		hand2.add(new Card(Suit.SPADE,7));
		hand2.add(new Card(Suit.SPADE,13));
		

        assertSame(hand2,CompareMaxNum.compare(hand1,hand2,PokerHand.NOTHING));
    }
}