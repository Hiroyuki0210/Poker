package poker.hand;

import poker.Card;

import java.util.List;

public class StraightFlush extends Hand implements Comparable<Hand>{
    private final List<Card> cards;

    public StraightFlush(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public int getHandRank(){
        return 1;
    }

    @Override
    public int getSuitRank(){
        return cards.get(cards.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "ストレートフラッシュ";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof StraightFlush)){
            return super.compareTo(o);
        }

        StraightFlush other = (StraightFlush)o;
        return compareRate(this.cards,other.cards);
    }
}