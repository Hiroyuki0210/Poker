package poker.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.Card;
import poker.Suit;

public class ThreeOfAKindTest{
    @Test
    public void threeOfAKind(){
        Hand hand = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,3),
				        new Card(Suit.SPADE,5),
			        	new Card(Suit.CLOVER,9)));

        assertThat(hand, instanceOf(ThreeOfAKind.class));
    }

    @Test
    public void compareThreeOfAKindMaxNum(){
        Hand hand1 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,3),
			        	new Card(Suit.HEART,3),
				        new Card(Suit.CLOVER,3),
				        new Card(Suit.SPADE,5),
                        new Card(Suit.CLOVER,9)));
    
        Hand hand2 = Hand.getHand(Arrays.asList(
			        	new Card(Suit.SPADE,10),
			        	new Card(Suit.HEART,10),
				        new Card(Suit.SPADE,10),
				        new Card(Suit.SPADE,7),
			        	new Card(Suit.CLOVER,8)));

        assertThat(hand1.compareTo(hand2),lessThan(0));
    }
}