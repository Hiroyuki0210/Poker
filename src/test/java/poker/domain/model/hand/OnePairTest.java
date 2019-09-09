package poker.domain.model.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.domain.model.Card;
import poker.domain.model.Suit;

public class OnePairTest{
    @Test
    public void onePair(){
        Hand hand = Hand.getHand(Arrays.asList(
				        new Card(Suit.SPADE,2),
				        new Card(Suit.HEART,2),
			        	new Card(Suit.CLOVER,5),
			        	new Card(Suit.SPADE,6),
			        	new Card(Suit.SPADE,8)));
        assertThat(hand, instanceOf(OnePair.class));
    }

    @Test
    public void compareOnePairMaxNum(){
        Hand hand1 = Hand.getHand(Arrays.asList(
				        new Card(Suit.SPADE,3),
				        new Card(Suit.HEART,3),
			        	new Card(Suit.CLOVER,7),
			        	new Card(Suit.SPADE,10),
                        new Card(Suit.SPADE,11)));
        
        Hand hand2 = Hand.getHand(Arrays.asList(
                        new Card(Suit.SPADE,1),
                        new Card(Suit.HEART,1),
                        new Card(Suit.CLOVER,5),
                        new Card(Suit.SPADE,6),
                        new Card(Suit.SPADE,8)));

        assertThat(hand1.compareTo(hand2),lessThan(0));
    }

    @Test
    public void compareOnePairSuit(){
        Hand hand1 = Hand.getHand(Arrays.asList(
				        new Card(Suit.CLOVER,3),
				        new Card(Suit.HEART,3),
			        	new Card(Suit.CLOVER,5),
			        	new Card(Suit.SPADE,6),
                        new Card(Suit.SPADE,8)));
        
        Hand hand2 = Hand.getHand(Arrays.asList(
                        new Card(Suit.DIAMOND,3),
                        new Card(Suit.SPADE,3),
                        new Card(Suit.CLOVER,7),
                        new Card(Suit.SPADE,9),
                        new Card(Suit.SPADE,12)));

        assertThat(hand1.getSuitRank(),lessThan(hand2.getSuitRank()));
    }
}