package poker.hand;

import poker.Card;

import java.util.List;

public class FullHouse extends Hand implements Comparable<Hand>{
    private final List<Card> three;
    private final List<Card> two;


    public FullHouse(List<Card> three, List<Card> two){
        this.three = three;
        this.two = two;
    }

    @Override
    public int getHandRank(){
        return 3;
    }

    @Override
    public int getSuitRank(){
        return three.get(three.size()-1).getSuit().strength;
    }

    @Override
    public String getName(){
        return "フルハウス";
    }

    @Override
    public int compareTo(Hand o){
        if(!(o instanceof FullHouse)){
            return super.compareTo(o);
        }

        FullHouse other = (FullHouse)o;
        int num = compareRate(this.three.get(0),other.three.get(0));
        if (num == 0) {
			return compareRate(this.two.get(0), other.two.get(0));
        }
        return num;
    }
}