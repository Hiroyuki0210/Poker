package poker.hand;

import org.junit.Test;
import poker.hand.hand.Hand;
import poker.hand.hand.Straight;

import java.util.Arrays;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class StraightTest {
	@Test
	public void straight() {
		Hand hand = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,3),
				new Card(Suit.CLOVER,4),
				new Card(Suit.SPADE,5),
				new Card(Suit.CLOVER,6)));

		assertThat(hand, instanceOf(Straight.class));
	}

	@Test
	public void compareStraight() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,3),
				new Card(Suit.CLOVER,4),
				new Card(Suit.SPADE,5),
				new Card(Suit.CLOVER,6)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,4),
				new Card(Suit.HEART,5),
				new Card(Suit.HEART,6),
				new Card(Suit.SPADE,7),
				new Card(Suit.CLOVER,8)));

		assertThat(h2, greaterThan(h1));
	}
}
