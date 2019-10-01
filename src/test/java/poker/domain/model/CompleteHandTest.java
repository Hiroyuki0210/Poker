package poker.domain.model;

import java.util.*;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.Test;

import poker.domain.model.Player;

//コンピュータの手札の役がnothing以外か否かのテスト

public class CompleteHandTest{
     CpuExchange cpuExchange = new CpuExchange();
     List<Card> computer1Hand = new ArrayList<>();
     List<Card> computer2Hand = new ArrayList<>();
     List<Player> computers = new ArrayList<>();
     boolean COMPLETE_HAND = false;

     //役がnothing
     @Test
     public void notCompleteHand(){
          //役なし手札
          computer1Hand.add(new Card(Suit.CLOVER,3));
          computer1Hand.add(new Card(Suit.SPADE,6));
          computer1Hand.add(new Card(Suit.HEART,9));
          computer1Hand.add(new Card(Suit.DIAMOND,10));
          computer1Hand.add(new Card(Suit.SPADE,13));

          Player computer1 = new Player(computer1Hand, 1);
          COMPLETE_HAND = cpuExchange.completeHand(computer1, 1);

          assertThat(COMPLETE_HAND, is(false));
     }

     //役がnothing以外
     @Test
     public void completeHandTest(){
          //1ペア手札
          computer1Hand.add(new Card(Suit.CLOVER,3));
          computer1Hand.add(new Card(Suit.HEART,3));
          computer1Hand.add(new Card(Suit.HEART,9));
          computer1Hand.add(new Card(Suit.DIAMOND,10));
          computer1Hand.add(new Card(Suit.SPADE,13));

          Player computer1 = new Player(computer1Hand, 1);
          COMPLETE_HAND = cpuExchange.completeHand(computer1, 1);

          assertThat(COMPLETE_HAND, is(true));
     }

}