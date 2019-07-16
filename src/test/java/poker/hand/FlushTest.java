package poker.hand;

import org.junit.Test;
import poker.hand.hand.Flush;
import poker.hand.hand.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class FlushTest {
	@Test
	public void flush() {
		List<Card> cards = new ArrayList<>();
		for (int i = 1; i < 10 ;i += 2) {
			cards.add(new Card(Suit.SPADE, i));
		}

		Hand hand = Hand.getHand(cards);
		assertThat(hand, instanceOf(Flush.class));
	}

	@Test
	public void compareFlush() {
		List<Card> cards = new ArrayList<>();
		for(int i=2; i <11 ; i += 2) {
			cards.add(new Card(Suit.SPADE,i));
		}

		Hand h1 = Hand.getHand(cards);

		Hand h2 = Hand.getHand(Arrays.asList(
				new Card(Suit.HEART,3),
				new Card(Suit.HEART,5),
				new Card(Suit.HEART,8),
				new Card(Suit.HEART,9),
				new Card(Suit.HEART,12)));

		assertThat(h2, greaterThan(h1));
	}
}
