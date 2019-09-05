package poker.domain.model.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.domain.model.Card;
import poker.domain.model.Suit;

public class StraightTest{
    @Test
    public void straight(){
        Hand hand = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,2),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,4),
				        new Card(Suit.SPADE,5),
			        	new Card(Suit.CLOVER,6)));

        assertThat(hand, instanceOf(Straight.class));
    }

    @Test
    public void compareStraightMaxNum(){
        Hand hand1 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,2),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,4),
				        new Card(Suit.SPADE,5),
                        new Card(Suit.CLOVER,6)));
    
        Hand hand2 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,4),
			        	new Card(Suit.HEART,5),
				        new Card(Suit.SPADE,6),
				        new Card(Suit.SPADE,7),
			        	new Card(Suit.CLOVER,8)));

        assertThat(hand1.compareTo(hand2),lessThan(0));
    }

    @Test
    public void compareStraightSuit(){
        Hand hand1 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,2),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,4),
				        new Card(Suit.SPADE,5),
                        new Card(Suit.CLOVER,6)));
    
        Hand hand2 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.HEART,2),
			        	new Card(Suit.CLOVER,3),
				        new Card(Suit.SPADE,4),
				        new Card(Suit.DIAMOND,5),
			        	new Card(Suit.HEART,6)));

        assertThat(hand1.getSuitRank(),lessThan(hand2.getSuitRank()));
    }
}