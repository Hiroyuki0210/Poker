package poker.domain.model;

import java.util.*;

import poker.domain.model.card.Card;

//プレイヤーに関する機能
public class Player{
     private List<Card> cards;

     public Player(List<Card> cards){
          this.cards = cards;
     }

     public List<Card> getCards(){
          return cards;
     }

}
