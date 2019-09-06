package poker.domain.model;

import java.util.*;

import poker.domain.model.card.Card;
import poker.domain.model.card.Deck;

//プレイヤーに関する機能
public class Player{
     private List<Card> cards;

     public Player(List<Card> cards){
          this.cards = cards;
     }

     public List<Card> getCards(){
          return cards;
     }

     //カード交換
     public void changeCard(int[] indices, Deck deck){
          //指定カードを捨てる
          List<Card> set = new ArrayList<>();
          for(int index : indices){
               Collections.addAll(set, cards.get(index));
          }
          cards.removeAll(set);

          //捨てた枚数分、カードを引く
          List<Card> drawCards = deck.draw(indices.length);
          cards.addAll(drawCards);
     }
}