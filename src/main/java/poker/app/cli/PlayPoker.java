package poker.app.cli;

import java.util.*;


import poker.domain.model.Card;
import poker.domain.service.PlayerHandDetail;
import poker.domain.service.PokerService;

/**
 * CLI 版
 */
public class PlayPoker {

	private static final int MAX_EXCHANGE_NUM = 3; 

	public static void main(String arg[]) {
		PokerService pokerService = new PokerService();

		//初期状態
		pokerService.initialize();
		println("初めのカードが配られました。");
		println("");
		printHand(pokerService.getPlayerHand());

		Scanner scan = new Scanner(System.in);

		int count = 0;
		while(count < MAX_EXCHANGE_NUM){
			println("交換したいカードの番号を選んでください。");
			println("番号は左から0,1,2,3,4となっていて、複数交換する場合は　,　で区切ってください。");
			println("交換せず終了する場合は、'q' を入力してください。\n");

			String input = scan.nextLine().trim();

			//ゲーム終了
			if(inputValueIsQuit(input)){
				println("終了します。");
				break;
			}

			try{
				int[] indices = parseInputValue(input);
				pokerService.exchangeCard(indices);

				printHand(pokerService.getPlayerHand());

				count++;
			}catch(IllegalArgumentException | IndexOutOfBoundsException e){
				println("入力値が誤っています。");
				println("終了します。");
				e.printStackTrace();
				break;
			}
		}
		scan.close();
	}
		
		//System.out.printlnの簡略版
		static void println(String message){
			System.out.println(message);
		}

		//入力値が'q'か否かの判定
		static boolean inputValueIsQuit(String line){
			return "q".equals(line);
		}
	
		//手札と役の表示
		private static void printHand(PlayerHandDetail playerHandDetail){
			println("手札 : "+ printCards(playerHandDetail.getCards()));
			println("役   : "+ playerHandDetail.getHand().getName());
			println("");
		}
	
		//手札のスートと数字の表示
		private static String printCards(List<Card> cards){
			StringBuilder sb = new StringBuilder();
			for(Card card : cards){
				sb.append(card.getSuit().icon);
				sb.append(card.getStringNum());
				sb.append("　　");
			}
	
			return sb.toString();
		}
	
		//入力された文字列を数字列に変換
		static int[] parseInputValue(String input){
			try{
				return Arrays.stream(input.split(","))
							.filter(str -> !str.isEmpty())
							.mapToInt(Integer::parseInt)
							.toArray();
			}catch(NumberFormatException e){
				throw new IllegalArgumentException(e.getMessage());
			}
		}
		
}
