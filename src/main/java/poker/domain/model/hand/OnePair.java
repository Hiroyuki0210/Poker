package poker.domain.model.hand;

import poker.domain.model.card.Card;

import java.util.List;

public class OnePair extends Hand implements Comparable<Hand>{
    private final List<Card> pair;

    public OnePair(List<Card> pair){
        this.pair = pair;
    }

    @Override
    public int getHandRank(){
        return 8;
    }

    @Override
    public int getSuitRank(){
        return pair.get(pair.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "1ペア";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof OnePair)){
            return super.compareTo(o);
        }

        OnePair other = (OnePair)o;
        
        return compareRate(this.pair.get(0),other.pair.get(0));
    }
}