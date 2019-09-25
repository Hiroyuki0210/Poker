package poker.domain.model;

import java.util.*;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.Test;

import poker.domain.service.PokerService;
import poker.domain.model.Player;

//コンピュータの自動交換メソッドのテスト
public class RankTest{
     PokerService pokerService = new PokerService(2);
     List<Card> playerHand = new ArrayList<>();
     List<Card> computer1Hand = new ArrayList<>();
     List<Card> computer2Hand = new ArrayList<>();
     List<Player> players = new ArrayList<>();
     List<Player> actualRank = new ArrayList<>();
     List<Player> expectedRank = new ArrayList<>();

     //役が異なる場合の順位
     @Test
     public void rankInDifferentHand(){
          playerHand.add(new Card(Suit.CLOVER,3));
          playerHand.add(new Card(Suit.SPADE,6));
          playerHand.add(new Card(Suit.HEART,9));
          playerHand.add(new Card(Suit.DIAMOND,10));
          playerHand.add(new Card(Suit.SPADE,13));
          Player player = new Player(playerHand,"プレイヤー");

          computer1Hand.add(new Card(Suit.SPADE,2));
		computer1Hand.add(new Card(Suit.HEART,2));
		computer1Hand.add(new Card(Suit.CLOVER,2));
		computer1Hand.add(new Card(Suit.SPADE,8));
          computer1Hand.add(new Card(Suit.HEART,8));
          Player computer1 = new Player(computer1Hand,"コンピュータ1");

          for (int i = 2; i < 11; i += 2) {
               computer2Hand.add(new Card(Suit.SPADE, i));
          }
          Player computer2 = new Player(computer2Hand,"コンピュータ2");

          players.add(player);
          players.add(computer1);
          players.add(computer2);

          actualRank = pokerService.result(players);

          expectedRank.add(computer1);
          expectedRank.add(computer2);
          expectedRank.add(player);

          assertThat(actualRank, is(expectedRank));
     }

     //役が同じ場合の順位(スートで評価)
     public void rankInSameHand1(){
          for (int i = 2; i < 11; i += 2) {
               playerHand.add(new Card(Suit.HEART, i));
          }
          Player player = new Player(playerHand,"プレイヤー");

          for (int i = 2; i < 11; i += 2) {
               computer1Hand.add(new Card(Suit.CLOVER, i));
          }
          Player computer1 = new Player(computer1Hand,"コンピュータ1");

          for (int i = 2; i < 11; i += 2) {
               computer2Hand.add(new Card(Suit.SPADE, i));
          }
          Player computer2 = new Player(computer2Hand,"コンピュータ2");

          players.add(player);
          players.add(computer1);
          players.add(computer2);

          actualRank = pokerService.result(players);

          expectedRank.add(computer2);
          expectedRank.add(player);
          expectedRank.add(computer1);
          
          assertThat(actualRank, is(expectedRank));
     }

     //役が同じ場合の順位(最大値で評価)
     public void rankInSameHand2(){
          for (int i = 8; i <= 12; i++) {
               playerHand.add(new Card(Suit.SPADE,i));
          }
          Player player = new Player(playerHand,"プレイヤー");

          for (int i = 2; i <= 6; i++) {
               computer1Hand.add(new Card(Suit.HEART,i));
          }
          Player computer1 = new Player(computer1Hand,"コンピュータ1");

          for (int i = 5; i <= 9; i++) {
               computer2Hand.add(new Card(Suit.DIAMOND,i));
          }
          Player computer2 = new Player(computer2Hand,"コンピュータ2");

          players.add(player);
          players.add(computer1);
          players.add(computer2);

          actualRank = pokerService.result(players);

          expectedRank.add(player);
          expectedRank.add(computer2);
          expectedRank.add(computer1);
          
          assertThat(actualRank, is(expectedRank));
     }
}