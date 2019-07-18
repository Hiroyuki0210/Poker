package poker.hand;

import poker.Card;

import java.util.List;

public class Nothing extends Hand implements Comparable<Hand>{
    private final List<Card> cards;

    public Nothing(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public int getHandRank(){
        return 9;
    }

    @Override
    public int getSuitRank(){
        return cards.get(cards.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "";
    }

    @Override
	public int compareTo(Hand o) {
		if (!(o instanceof Nothing)) {
			return super.compareTo(o);
        }
        Nothing other = (Nothing)o;
		return compareRate(this.cards,other.cards);
	}
}