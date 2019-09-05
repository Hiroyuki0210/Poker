package poker.domain.model.hand;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import java.util.*;
import poker.domain.model.Card;
import poker.domain.model.Suit;

public class FullHouseTest{
    @Test
    public void FullHouse(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.SPADE,2));
		cards.add(new Card(Suit.HEART,2));
		cards.add(new Card(Suit.CLOVER,2));
		cards.add(new Card(Suit.SPADE,8));
        cards.add(new Card(Suit.HEART,8));
        
        assertThat(Hand.getHand(cards),instanceOf(FullHouse.class));
    }

    @Test
    public void compareFullHouseMaxNum(){
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        cards1.add(new Card(Suit.SPADE,13));
		cards1.add(new Card(Suit.HEART,13));
		cards1.add(new Card(Suit.CLOVER,13));
		cards1.add(new Card(Suit.SPADE,8));
        cards1.add(new Card(Suit.HEART,8));

        cards2.add(new Card(Suit.SPADE,1));
		cards2.add(new Card(Suit.HEART,1));
		cards2.add(new Card(Suit.CLOVER,1));
		cards2.add(new Card(Suit.SPADE,10));
        cards2.add(new Card(Suit.HEART,10));

        assertThat(Hand.getHand(cards1).compareTo(Hand.getHand(cards2)),lessThan(0));
    }
}
    