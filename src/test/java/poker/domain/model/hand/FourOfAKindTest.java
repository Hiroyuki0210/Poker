package poker.domain.model.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;

import poker.domain.model.card.Card;
import poker.domain.model.card.Suit;

public class FourOfAKindTest{
    @Test
    public void FourOfAKind(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.SPADE,2));
		cards.add(new Card(Suit.HEART,2));
		cards.add(new Card(Suit.CLOVER,2));
		cards.add(new Card(Suit.DIAMOND,2));
        cards.add(new Card(Suit.SPADE,8));
        
        assertThat(Hand.getHand(cards), instanceOf(FourOfAKind.class));
    }

    @Test
    public void compareFourOfAKindMaxNum(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        cards1.add(new Card(Suit.SPADE,2));
		cards1.add(new Card(Suit.HEART,2));
		cards1.add(new Card(Suit.CLOVER,2));
		cards1.add(new Card(Suit.DIAMOND,2));
        cards1.add(new Card(Suit.SPADE,8));

        cards2.add(new Card(Suit.SPADE,5));
		cards2.add(new Card(Suit.HEART,5));
		cards2.add(new Card(Suit.CLOVER,5));
		cards2.add(new Card(Suit.DIAMOND,5));
        cards2.add(new Card(Suit.SPADE,6));

        assertThat(Hand.getHand(cards1).compareTo(Hand.getHand(cards2)), lessThan(0));
    }
    
}