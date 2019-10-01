package poker.domain.model;

import java.util.*;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.Test;

import poker.domain.service.PokerService;
import poker.domain.model.Player;

//コンピュータの自動交換メソッドのテスト
public class RankTest{
     static PokerService pokerService = new PokerService(2);
     
     static List<Player> players;
     static Player player;
     static Player computer1;
     static Player computer2;
     static List<Card> playerHand;
     static List<Card> computer1Hand;
     static List<Card> computer2Hand;
     List<Player> actualRank;
     List<Player> expectedRank = new ArrayList<>();
     
     /**
      * 各プレイヤーの手札に特定のカードを設定するため、
      * PokerServiceのinitializeで配られた手札をclearする。
      */
     static void initialize(){
          pokerService.initialize();

          players = pokerService.getPlayers();
          player = players.get(0);
          computer1 = players.get(1);
          computer2 = players.get(2);

          for (Player eachPlayer : players) {
               eachPlayer.getCards().clear();
          }

          playerHand = player.getCards();
          computer1Hand = computer1.getCards();
          computer2Hand = computer2.getCards();
     }

     //役が異なる場合の順位
     @Test
     public void rankInDifferentHand(){
          initialize();

          playerHand.add(new Card(Suit.CLOVER,3));
          playerHand.add(new Card(Suit.SPADE,6));
          playerHand.add(new Card(Suit.HEART,9));
          playerHand.add(new Card(Suit.DIAMOND,10));
          playerHand.add(new Card(Suit.SPADE,13));
          
          computer1Hand.add(new Card(Suit.SPADE,2));
		computer1Hand.add(new Card(Suit.HEART,2));
		computer1Hand.add(new Card(Suit.CLOVER,2));
		computer1Hand.add(new Card(Suit.SPADE,8));
          computer1Hand.add(new Card(Suit.HEART,8));

          for (int i = 2; i < 11; i += 2) {
               computer2Hand.add(new Card(Suit.SPADE, i));
          }

          actualRank = pokerService.result();

          expectedRank.add(computer1);
          expectedRank.add(computer2);
          expectedRank.add(player);

          assertThat(actualRank, is(expectedRank));
     }

     @Test
     //役が同じ場合の順位(スートで評価)
     public void rankInSameHand1(){
          initialize();

          for (int i = 2; i < 11; i += 2) {
               playerHand.add(new Card(Suit.DIAMOND, i));
          }

          for (int i = 2; i < 11; i += 2) {
               computer1Hand.add(new Card(Suit.CLOVER, i));
          }

          for (int i = 2; i < 11; i += 2) {
               computer2Hand.add(new Card(Suit.SPADE, i));
          }

          actualRank = pokerService.result();

          expectedRank.add(computer2);
          expectedRank.add(player);
          expectedRank.add(computer1);
          
          assertThat(actualRank, is(expectedRank));
     }

     @Test
     //役が同じ場合の順位(最大値で評価)
     public void rankInSameHand2(){
          initialize();

          for (int i = 8; i <= 12; i++) {
               playerHand.add(new Card(Suit.SPADE,i));
          }

          for (int i = 2; i <= 6; i++) {
               computer1Hand.add(new Card(Suit.HEART,i));
          }

          for (int i = 5; i <= 9; i++) {
               computer2Hand.add(new Card(Suit.DIAMOND,i));
          }

          actualRank = pokerService.result();

          expectedRank.add(player);
          expectedRank.add(computer2);
          expectedRank.add(computer1);
          
          assertThat(actualRank, is(expectedRank));
     }

}