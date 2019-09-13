package poker.domain.service;

import java.util.*;

import poker.domain.model.card.Deck;
import poker.domain.model.card.Card;
import poker.domain.model.hand.Hand;
import poker.domain.model.Player;


public class PokerService{

     private Deck deck;
     private Player player;

     public void initialize(){
          deck = new Deck();
          List<Card> cards = deck.draw(5);
          player = new Player(cards);
     }

     public PlayerHandDetail getPlayerHand(){
          List<Card> cards = player.getCards();
          Hand hand = Hand.getHand(cards);

          return new PlayerHandDetail(cards, hand);
     }

     //カード交換
     public void exchangeCard(int[] indices){
          List<Card> cards = player.getCards();
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
