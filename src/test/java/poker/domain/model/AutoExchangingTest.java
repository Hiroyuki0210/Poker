package poker.domain.model;

import java.util.*;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.Test;

import poker.domain.service.PokerService;
import poker.domain.model.Player;

//コンピュータの自動交換メソッドのテスト
public class AutoExchangingTest{
     PokerService pokerService = new PokerService(1);
     List<Card> computerHand = new ArrayList<>();

     @Test
     public void autoExchangingTest(){
          //デッキをセットするためにinitialize()をする。
          pokerService.initialize();

          //役なし手札
          computerHand.add(new Card(Suit.CLOVER,3));
          computerHand.add(new Card(Suit.SPADE,6));
          computerHand.add(new Card(Suit.HEART,9));
          computerHand.add(new Card(Suit.DIAMOND,10));
          computerHand.add(new Card(Suit.SPADE,13));

          Player computer = new Player(computerHand,"コンピュータ1");

          List<Card> before = new ArrayList<>();
          before.addAll(computerHand);

          pokerService.autoExchangeCard(computer);

          List<Card> after = computer.getCards();
          
          assertThat(before, is(not(after)));
          
     }
}