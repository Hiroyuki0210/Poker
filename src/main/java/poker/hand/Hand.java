package poker.hand;

import java.util.*;

import poker.Card;
import poker.Suit;

public abstract class Hand implements Comparable<Hand>{
    public abstract int getHandRank();
    public abstract int getSuitRank();
    public abstract String getName();

    //役の判定
    public static Hand getHand(List<Card> hand){
        boolean isStraight = isStraight(hand);
        boolean isFlush  = isFlush(hand);

        if(isStraight && isFlush){
            if(hand.get(0).getNum() == 1 && hand.get(4).getNum() == 13){
                return new RoyalStraightFlush(hand);
            }

            return new StraightFlush(hand);
        }

        Hand pairHand = getPairs(hand);
        if(pairHand instanceof FourOfAKind || pairHand instanceof ThreeOfAKind || pairHand instanceof TwoPair || pairHand instanceof OnePair|| pairHand instanceof FullHouse){
            return pairHand;
        }

        if(isFlush) return new Flush(hand);
        if(isStraight) return new Straight(hand);

        return pairHand;
    }

    //カード番号が連続するか否かの判定
    static boolean isStraight(List<Card> hand){
        int last;
        last = hand.get(1).getNum();

        for(int id = 2; id < hand.size(); id++){
            Card card = hand.get(id);
            if(last + 1 != card.getNum()){
                return false;
            }
            last = card.getNum();
        }

        int top = hand.get(0).getNum();
        return top + 4 == last || (last == 13 && top == 1);
    }

    //ペアカードがあるか否かの判定
    static boolean isFlush(List<Card> hand){
        Suit suit = hand.get(0).getSuit();

        for(Card card : hand){
            if(card.getSuit() != suit){
                return false;
            }
        }

        return true;
    }

    static Hand getPairs(List<Card> hand){
        //ペアカードとそれ以外のカードをtempに格納
        Map<Integer, List<Card>> temp = new HashMap<>();
        for(Card card : hand){
            List<Card> value = temp.getOrDefault(card.getNum(),new ArrayList<>());
            value.add(card);
            temp.put(card.getNum(),value);
        }

        //ペアカードとそれ以外のカードの分類
        Map<Integer,List<Card>> counter = new HashMap<>();
        List<Card> leftover = new ArrayList<>();
        for(Map.Entry<Integer,List<Card>> entry: temp.entrySet()){
            if(entry.getValue().size() == 1){
                leftover.addAll(entry.getValue());
            }else{
                counter.put(entry.getKey(),entry.getValue());
            }
        }

        //ペアカードが格納されてる配列をMap型→List型に変更
        List<List<Card>> values = new ArrayList<>(counter.values());

        //残り物のカードleftoverの数によって、ペアに関する役を分類
        switch(leftover.size()){
            case 0:
                List<Card> c1 = values.get(0);
                List<Card> c2 = values.get(1);

                if(c1.size() == 3){
                    return new FullHouse(c1,c2);
                }else{
                    return new FullHouse(c2,c1);
                }
            case 1:
                if(counter.size() == 1){
                    return new FourOfAKind(values.get(0));
                }else{
                    return new TwoPair(values.get(0),values.get(1));
                }
            case 2:
                return new ThreeOfAKind(values.get(0));
            case 3:
                return new OnePair(values.get(0));
            default:
                return new Nothing(leftover);
        }
    }

    //役の強弱の比較(オーバーライド先では役が同じ場合、数字を比較)
    public int compareTo(Hand o){
        return o.getHandRank() - this.getHandRank();
    }

    //役が同じ場合の数字の比較(数字が最も大きい要素同士で行う)
    static int compareRate(List<Card> list1, List<Card> list2){
        assert list1.size() == list2.size();

        return compareRate(list1.get(list1.size()-1),list2.get(list2.size()-1));
    }

    //役が同じ場合の数字の比較
    static int compareRate(Card c1, Card c2){
        return c1.getNum() - c2.getNum();
    }
}