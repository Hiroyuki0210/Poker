package poker.hand;

import org.junit.Test;
import poker.hand.hand.FourOfAKind;
import poker.hand.hand.Hand;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class FourOfAKindTest {
	@Test
	public void fourCard() {
		Hand hand = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.DIAMOND,2),
				new Card(Suit.SPADE,8)));

		assertThat(hand, instanceOf(FourOfAKind.class));
	}

	@Test
	public void compareFourCard() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.DIAMOND,2),
				new Card(Suit.SPADE,8)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,5),
				new Card(Suit.HEART,5),
				new Card(Suit.CLOVER,5),
				new Card(Suit.DIAMOND,5),
				new Card(Suit.HEART,8)));

		assertThat(h2, greaterThan(h1));
		assertThat(h1, lessThan(h2));
	}

	@Test
	public void compareFourCardAndKick() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.DIAMOND,2),
				new Card(Suit.SPADE,3)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.DIAMOND,2),
				new Card(Suit.HEART,5)));

		assertThat(h2, greaterThan(h1));
		assertThat(h1, lessThan(h2));
	}

	@Test
	public void sameFourCard() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.DIAMOND,2),
				new Card(Suit.SPADE,3)));

		assertThat(h1, comparesEqualTo(h1));
	}
}
