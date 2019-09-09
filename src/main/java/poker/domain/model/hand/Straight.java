package poker.domain.model.hand;

import java.util.List;

import poker.domain.model.Card;

public class Straight extends Hand implements Comparable<Hand>{
    private final List<Card> cards;

    public Straight(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public int getHandRank(){
        return 5;
    }

    @Override
    public int getSuitRank(){
        return cards.get(cards.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "ストレート";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof Straight)){
            return super.compareTo(o);
        }

        Straight other = (Straight) o;
        return compareRate(this.cards, other.cards);
    }
}