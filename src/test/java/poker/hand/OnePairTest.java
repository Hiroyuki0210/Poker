package poker.hand;

import org.junit.Test;
import poker.hand.hand.Hand;
import poker.hand.hand.OnePair;

import java.util.Arrays;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class OnePairTest {
	@Test
	public void onePair() {
		Hand hand = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,5),
				new Card(Suit.SPADE,6),
				new Card(Suit.SPADE,8)));

		assertThat(hand, instanceOf(OnePair.class));
	}

	@Test
	public void compareOnePair() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,4),
				new Card(Suit.HEART,4),
				new Card(Suit.CLOVER,6),
				new Card(Suit.SPADE,8),
				new Card(Suit.CLOVER,13)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,5),
				new Card(Suit.HEART,5),
				new Card(Suit.CLOVER,7),
				new Card(Suit.SPADE,9),
				new Card(Suit.SPADE,12)));

		assertThat(h2, greaterThan(h1));
	}
}
