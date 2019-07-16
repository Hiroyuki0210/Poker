package poker.hand;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import poker.hand.hand.*;

//10種類の役のテスト
public class NothingTest {
	@Test
	public void nothing() {
		Hand hand = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,4),
				new Card(Suit.CLOVER,7),
				new Card(Suit.SPADE,8),
				new Card(Suit.HEART,10)));

		assertThat(hand, instanceOf(Nothing.class));
	}

	@Test
	public void compareNothing() {
		Hand h1 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,2),
				new Card(Suit.HEART,4),
				new Card(Suit.CLOVER,6),
				new Card(Suit.SPADE,8),
				new Card(Suit.CLOVER,11)));

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.SPADE,3),
				new Card(Suit.HEART,5),
				new Card(Suit.CLOVER,7),
				new Card(Suit.SPADE,10),
				new Card(Suit.SPADE,13)));

		assertThat(h1, comparesEqualTo(h2));
	}
}