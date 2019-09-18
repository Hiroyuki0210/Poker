package poker.domain.model.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.domain.model.Card;
import poker.domain.model.Suit;

public class FlushTest{
    @Test
    public void flush(){
        List<Card> cards = new ArrayList<>();
        for(int i=1; i < 10; i++){
            cards.add(new Card(Suit.SPADE, i));
        }
        assertThat(Hand.getHand(cards), instanceOf(Flush.class));
    }

    @Test
    public void compareFlushMaxNum(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        for(int i=2; i<11; i+=2){
            cards1.add(new Card(Suit.SPADE, i));
            cards2.add(new Card(Suit.HEART, i+1));
        }

        assertThat(Hand.getHand(cards1).compareTo(Hand.getHand(cards2)), lessThan(0));
    }

    @Test
    public void compareFlushSuit(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        for(int i=2; i<11; i+=2){
            cards1.add(new Card(Suit.SPADE, i));
            cards2.add(new Card(Suit.HEART, i));
        }   
        assertThat(Hand.getHand(cards2).getSuitRank(), lessThan(Hand.getHand(cards1).getSuitRank()));
    }
}