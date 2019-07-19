package poker.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.Card;
import poker.Suit;

public class NothingTest{
    @Test
    public void nothing(){
        Hand hand = Hand.getHand(Arrays.asList(
                    new Card(Suit.SPADE, 2),
                    new Card(Suit.HEART,5),
                    new Card(Suit.CLOVER,7),
                    new Card(Suit.DIAMOND,8),
                    new Card(Suit.HEART,10)));
        
        assertThat(hand, instanceOf(Nothing.class));
    }

    @Test
    public void compareNothingMaxNum(){
        Hand hand1 = Hand.getHand(Arrays.asList(
                    new Card(Suit.SPADE, 2),
                    new Card(Suit.HEART,5),
                    new Card(Suit.CLOVER,7),
                    new Card(Suit.DIAMOND,8),
                    new Card(Suit.HEART,12)));

        Hand hand2 = Hand.getHand(Arrays.asList(
                    new Card(Suit.SPADE, 4),
                    new Card(Suit.HEART,6),
                    new Card(Suit.CLOVER,9),
                    new Card(Suit.DIAMOND,11),
                    new Card(Suit.HEART,13)));        

        assertThat(hand1.compareTo(hand2), lessThan(0));
    }

    @Test
    public void compareNothingSuit(){
        Hand hand1 = Hand.getHand(Arrays.asList(
                    new Card(Suit.SPADE, 2),
                    new Card(Suit.HEART,5),
                    new Card(Suit.CLOVER,7),
                    new Card(Suit.DIAMOND,8),
                    new Card(Suit.HEART,12)));
                    
        Hand hand2 = Hand.getHand(Arrays.asList(
                    new Card(Suit.SPADE, 4),
                    new Card(Suit.HEART,6),
                    new Card(Suit.CLOVER,9),
                    new Card(Suit.DIAMOND,11),
                    new Card(Suit.SPADE,12)));
        assertThat(hand1.getSuitRank(), lessThan(hand2.getSuitRank()));
    }
}