package poker.domain.model;

import java.util.*;

import poker.domain.model.Card;

//プレイヤーに関する機能
public class Player{
     private List<Card> cards;

     public Player(List<Card> cards){
          this.cards = cards;
     }

     public List<Card> getCards(){
          return cards;
     }

     public void changeCard(int[] indices, List<Card> newCards){
          List<Card> set = new ArrayList<>();
          for(int index : indices){
               Collections.addAll(set, cards.get(index));
          }
          cards.removeAll(set);

          cards.addAll(newCards);
     }

}
