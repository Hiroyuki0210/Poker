package poker.domain.model.hand;

import java.util.*;
import poker.domain.model.card.Card;

public class RoyalStraightFlush extends Hand implements Comparable<Hand>{
    private final List<Card> cards;

    public RoyalStraightFlush(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public int getHandRank(){
        return 0;
    }

    @Override
    public int getSuitRank(){
        return cards.get(cards.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "ロイヤルストレートフラッシュ";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof RoyalStraightFlush)){
            return super.compareTo(o);
        }
        return 0;
    }
}