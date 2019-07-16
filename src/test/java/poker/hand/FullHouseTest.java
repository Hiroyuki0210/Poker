package poker.hand;

import org.junit.Test;
import poker.hand.hand.FullHouse;
import poker.hand.hand.Hand;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class FullHouseTest {
	@Test
	public void fullHouse() {
		Hand hand = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,2),
				new Card(Suit.CLOVER,2),
				new Card(Suit.SPADE,8),
				new Card(Suit.HEART,8)));

		assertThat(hand, instanceOf(FullHouse.class));
	}

	@Test
	public void compareFullHouse() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,4),
				new Card(Suit.HEART,4),
				new Card(Suit.CLOVER,4),
				new Card(Suit.SPADE,8),
				new Card(Suit.HEART,8)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,3),
				new Card(Suit.HEART,3),
				new Card(Suit.CLOVER,3),
				new Card(Suit.SPADE,10),
				new Card(Suit.HEART,10)));

		assertThat(h1, greaterThan(h2));
		assertThat(h2, lessThan(h1));
	}

	@Test
	public void compareFullHouse2() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,3),
				new Card(Suit.HEART,3),
				new Card(Suit.CLOVER,3),
				new Card(Suit.SPADE,8),
				new Card(Suit.HEART,8)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,3),
				new Card(Suit.HEART,3),
				new Card(Suit.CLOVER,3),
				new Card(Suit.SPADE,10),
				new Card(Suit.HEART,10)));

		assertThat(h2, greaterThan(h1));
		assertThat(h1, lessThan(h2));
	}

	@Test
	public void sameFullHouse2() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,3),
				new Card(Suit.HEART,3),
				new Card(Suit.CLOVER,3),
				new Card(Suit.SPADE,3),
				new Card(Suit.HEART,8)));

		assertThat(h1, comparesEqualTo(h1));
	}
}
