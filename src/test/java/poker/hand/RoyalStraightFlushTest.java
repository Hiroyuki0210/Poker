package poker.hand;

import org.junit.Test;
import poker.hand.hand.Hand;
import poker.hand.hand.RoyalStraightFlush;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class RoyalStraightFlushTest {
	@Test
	public void royalStraightFlush() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.SPADE,1));
		for (int i = 10; i <= 13 ;i++) {
			cards.add(new Card(Suit.SPADE,i));
		}

		Hand hand = Hand.getHand(cards);
		assertThat(hand, instanceOf(RoyalStraightFlush.class));
	}
}
