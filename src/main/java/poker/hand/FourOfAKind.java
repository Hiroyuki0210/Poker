package poker.hand;

import poker.Card;

import java.util.List;

public class FourOfAKind extends Hand implements Comparable<Hand>{
    private final List<Card> four;

    public FourOfAKind(List<Card> four){
        this.four = four;
    }

    @Override
    public int getHandRank(){
        return 2;
    }

    @Override
    public int getSuitRank(){
        return four.get(four.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "4カード";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof FourOfAKind)){
            return super.compareTo(o);
        }

        FourOfAKind other = (FourOfAKind)o;
        return compareRate(this.four.get(0),other.four.get(0));
    }
}