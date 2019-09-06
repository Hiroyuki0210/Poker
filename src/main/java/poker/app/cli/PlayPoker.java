package poker.app.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

import poker.domain.model.card.Card;
import poker.domain.model.card.Deck;
import poker.domain.model.card.Suit;
import poker.domain.model.CardComparator;
import poker.domain.model.hand.Hand;
import poker.domain.service.PokerService;
import poker.domain.service.PlayerHandDetail;

/**
 * CLIverポーカー
 */

public class PlayPoker {
	private static final int MAX_EXCHANGE_NUM = 3; 

	public static void main(String arg[]) {
		PokerService pokerService = new PokerService();
		//初期状態
		pokerService.initialize();
		println("初めのカードが配られました。");
		printHand(pokerService.getPlayerHand());

		Scanner scan = new Scanner(System.in);

		int count = 0;
		while(count < MAX_EXCHANGE_NUM){
			println("交換したいカードの番号を選んでください。番号は左から0,1,2,3,4となっていて、複数交換する場合は　,　で区切ってください。");
			println("交換せず終了する場合は、'q' を入力してください。");

			String input = scan.nextLine().trim();

			if(input.equals("q")){
				break;
			}

			try{
				int[] indices = parseInput(input);
			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}
		}
		
		
		private static void println(String message){
			System.out.println(message);
		}
	
		private static void printHand(PlayerHandDetail playerHandDetail){
			println("手札 : "+ printCards(playerHandDetail.getCards()));
			println("役   : "+ playerHandDetail.getHand().getName());
		}
	
		private static String printCards(List<Card> cards){
			StringBuilder sb = new StringBuilder();
			for(Card card : cards){
				sb.append(card.getSuit().icon);
				sb.append(card.getNum());
				sb.append("　　");
			}
	
			return sb.toString();
		}
	
	
		static int[] parseInput(String input){
			try{
				 return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
			}catch(NumberFormatException e){
				println("0~4の数字もしくは'q'を入力してください。");
			}
		}
		

		
}
