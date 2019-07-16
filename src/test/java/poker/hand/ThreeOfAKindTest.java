package poker.hand;

import org.junit.Test;
import poker.hand.hand.Hand;
import poker.hand.hand.ThreeOfAKind;

import java.util.Arrays;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class ThreeOfAKindTest {
	@Test
	public void threeCard() {
		Hand hand = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.SPADE,5),
				new Card(Suit.SPADE,8)));

		assertThat(hand, instanceOf(ThreeOfAKind.class));
	}

	@Test
	public void compareThreeCard() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,4),
				new Card(Suit.HEART,4),
				new Card(Suit.CLOVER,4),
				new Card(Suit.SPADE,6),
				new Card(Suit.CLOVER,8)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,5),
				new Card(Suit.HEART,5),
				new Card(Suit.CLOVER,5),
				new Card(Suit.SPADE,7),
				new Card(Suit.SPADE,8)));

		assertThat(h2, greaterThan(h1));
	}
}
