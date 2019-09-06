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
}