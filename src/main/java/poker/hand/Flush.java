package poker.hand;

import poker.Card;

import java.util.List;

public class Flush extends Hand implements Comparable<Hand>{
    private final List<Card> cards;

    public Flush(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public int getHandRank(){
        return 4;
    }

    @Override
    public int getSuitRank(){
        return cards.get(cards.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "フラッシュ";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof Flush)){
            return super.compareTo(o);
        }

        Flush other = (Flush)o;
        return compareRate(this.cards, other.cards);
    }

}