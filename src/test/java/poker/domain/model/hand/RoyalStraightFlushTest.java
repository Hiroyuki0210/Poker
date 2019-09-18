package poker.domain.model.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.domain.model.Card;
import poker.domain.model.Suit;

public class RoyalStraightFlushTest{
    @Test
    public void royalStraightFlush(){
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(Suit.SPADE,1));
        for(int i=10; i<=13; i++){
            cards.add(new Card(Suit.SPADE,i));
        }

        assertThat(Hand.getHand(cards), instanceOf(RoyalStraightFlush.class));
    }

    @Test
    public void compareRoyalStraightFlushSuit(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        cards1.add(new Card(Suit.HEART,1));
        for(int i=10; i<=13; i++){
            cards1.add(new Card(Suit.HEART,i));
        }
        cards2.add(new Card(Suit.SPADE,1));
        for(int i=10; i<=13; i++){
            cards2.add(new Card(Suit.SPADE,i));
        }

        assertThat(Hand.getHand(cards1).getSuitRank(),lessThan(Hand.getHand(cards2).getSuitRank()));
    }
}