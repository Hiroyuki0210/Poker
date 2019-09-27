package poker.app.cli;

import poker.domain.model.Card;
import poker.domain.model.Player;
import poker.domain.service.PlayerHandDetail;
import poker.domain.service.PokerService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CLI 版
 */
public class PlayPoker {

	private static final int MAX_EXCHANGE_NUM = 3;

	public static void main(String arg[]) {
		Scanner scan = new Scanner(System.in);

		println("対戦相手(コンピュータ)の数を入力してください。");
		println("コンピュータ数の上限は2です。");
		println("1人でプレイする場合は、0を入力してください。");

		try {
			int numberOfComputer = Integer.parseInt(scan.nextLine());
			if (! inputNumberOfComputer(numberOfComputer)) {
				scan.close();
				throw new IndexOutOfBoundsException("0～3 の数を入力してください。");
			}
			PokerService pokerService = new PokerService(numberOfComputer);
		
		
			//初期状態
			pokerService.initialize();
			List<Player> players = pokerService.getPlayers();
			println("初めのカードが配られました。\n");

			println("ラウンド1\n");

			for (Player player : players) {
				println(player.getName());
				printHand(pokerService.getPlayerHand(player));
				println("");
			}


			//カード交換
			int count = 0;
			boolean COMPLETE_HAND = false;
			String input = null;

			println("<カード交換>");
			println("交換したいカードの番号を選んでください。");
			println("番号は左から0,1,2,3,4となっていて、複数交換する場合は　,　で区切ってください。");
			println("交換せず終了する場合は、'q' を入力してください。\n");
 
			loop : while (count < MAX_EXCHANGE_NUM) {
				println("ラウンド" + (count+2) + "\n");

				for (Player player : players) {
					println(player.getName() + "　のターンです。");

					if (player.getName().equals("プレイヤー")) {
						input = scan.nextLine().trim();
						
						//ゲーム終了
						if (inputValueIsQuit(input)) {
							printHand(pokerService.getPlayerHand(player));
							continue;
						}
	
						try {
							int[] indices = parseInputValue(input);
							pokerService.exchangeCard(indices, player);
	
						} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
							println("入力値が誤っています。");
							println("終了します。");
							e.printStackTrace();
							break;
						}
					}else{
						pokerService.autoExchangeCard(player);
						
						COMPLETE_HAND = pokerService.completeHand(player);
					}

					printHand(pokerService.getPlayerHand(player));

					if (inputValueIsQuit(input) && COMPLETE_HAND) {
						break loop;
					}
				}

				println("");

				count++;

			}

			//結果
			println("<結果>");
			List<Player> rankList = pokerService.result(players);
			for (int i = 0; i < rankList.size() ; i++) {
				println((i+1) + "位 : " + rankList.get(i).getName());
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		scan.close();

	}

	//System.out.printlnの簡略版
	static void println(String message) {
		System.out.println(message);
	}

	static boolean inputNumberOfComputer(int num){
		return (0 <= num && num <= 2);
	}

	//入力値が'q'か否かの判定
	static boolean inputValueIsQuit(String line) {
		return "q".equals(line);
	}

	//手札と役の表示
	private static void printHand(PlayerHandDetail playerHandDetail) {
		println("手札 : " + printCards(playerHandDetail.getCards()));
		println("役   : " + playerHandDetail.getHand().getName());
		println("");
	}

	//手札のスートと数字の表示
	private static String printCards(List<Card> cards) {
		StringBuilder sb = new StringBuilder();
		for (Card card : cards) {
			sb.append(card.getSuit().icon);
			sb.append(card.getStringNum());
			sb.append("　　");
		}

		return sb.toString();
	}

	//入力された文字列を数字列に変換
	static int[] parseInputValue(String input) {
		try {
			return Arrays.stream(input.split(","))
					.filter(str -> !str.isEmpty())
					.mapToInt(Integer::parseInt)
					.toArray();
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}
