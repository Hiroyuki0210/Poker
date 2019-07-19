package poker.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.Card;
import poker.Suit;

public class StraightFlushTest{
    @Test
    public void straightFlush(){
        List<Card> cards = new ArrayList<>();

        for(int i=1; i<=5; i++){
            cards.add(new Card(Suit.SPADE,i));
        }

        assertThat(Hand.getHand(cards), instanceOf(StraightFlush.class));
    }

    @Test
    public void compareStraightFlushMaxNum(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        for(int i=1; i<=5; i++){
            cards1.add(new Card(Suit.HEART,i));
        }
        for(int i=2; i<=6; i++){
            cards2.add(new Card(Suit.SPADE,i));
        }

        assertThat(Hand.getHand(cards1).compareTo(Hand.getHand(cards2)),lessThan(0));
    }

    @Test
    public void compareStraightFlushSuit(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        for(int i=3; i<=7; i++){
            cards1.add(new Card(Suit.HEART,i));
        }
        for(int i=3; i<=7; i++){
            cards2.add(new Card(Suit.SPADE,i));
        }

        assertThat(Hand.getHand(cards1).getSuitRank(),lessThan(Hand.getHand(cards2).getSuitRank()));
    }
}