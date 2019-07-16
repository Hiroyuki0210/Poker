package poker.hand;

import org.junit.Test;
import poker.hand.hand.Hand;
import poker.hand.hand.StraightFlush;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class StraightFlushTest {
	@Test
	public void straightFlush() {
		List<Card> cards = new ArrayList<>();
		for (int i = 1; i <= 5 ;i++) {
			cards.add(new Card(Suit.SPADE,i));
		}

		Hand hand = Hand.getHand(cards);
		assertThat(hand, instanceOf(StraightFlush.class));
	}


	@Test
	public void compareStraightFlush() {
		List<Card> hand1 = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			hand1.add(new Card(Suit.SPADE, i));
		}

		List<Card> hand2 = new ArrayList<>();
		for(int i = 2; i <= 6; i++) {
			hand2.add(new Card(Suit.SPADE, i));
		}

		Hand h1 = Hand.getHand(hand1);
		Hand h2 = Hand.getHand(hand2);

		assertThat(h2, greaterThan(h1));
	}

	@Test
	public void sameStraightFlush() {
		List<Card> hand1 = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			hand1.add(new Card(Suit.SPADE, i));
		}

		Hand h1 = Hand.getHand(hand1);
		Hand h2 = Hand.getHand(hand1);

		assertThat(h2, comparesEqualTo(h1));
	}

}
