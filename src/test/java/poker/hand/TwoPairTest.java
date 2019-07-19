package poker.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.Card;
import poker.Suit;

public class TwoPairTest{
    @Test
    public void twoPair(){
        Hand hand = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,5),
				        new Card(Suit.SPADE,5),
			        	new Card(Suit.CLOVER,9)));

        assertThat(hand, instanceOf(TwoPair.class));
    }

    @Test
    public void compareTwoPairMaxNum1(){
        Hand hand1 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,5),
				        new Card(Suit.SPADE,5),
                        new Card(Suit.CLOVER,9)));
    
        Hand hand2 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.SPADE,6),
				        new Card(Suit.SPADE,6),
			        	new Card(Suit.CLOVER,8)));

        assertThat(hand1.compareTo(hand2),lessThan(0));
    }

    @Test
    public void compareTwoPairMaxNum2(){
        Hand hand1 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,6),
				        new Card(Suit.SPADE,6),
                        new Card(Suit.CLOVER,9)));
    
        Hand hand2 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,4),
			        	new Card(Suit.HEART,4),
				        new Card(Suit.SPADE,6),
				        new Card(Suit.SPADE,6),
			        	new Card(Suit.CLOVER,8)));

        assertThat(hand1.compareTo(hand2),lessThan(0));
    }

    @Test
    public void compareTwoPairSuit(){
        Hand hand1 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.CLOVER,3),
			        	new Card(Suit.SPADE,3),
				        new Card(Suit.CLOVER,6),
				        new Card(Suit.HEART,6),
                        new Card(Suit.CLOVER,9)));
    
        Hand hand2 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.DIAMOND,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.SPADE,6),
				        new Card(Suit.DIAMOND,6),
			        	new Card(Suit.HEART,10)));

        assertThat(hand1.getSuitRank(),lessThan(hand2.getSuitRank()));
    }
}