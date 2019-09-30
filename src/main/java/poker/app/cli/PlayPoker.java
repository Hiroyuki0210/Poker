package poker.app.cli;

import poker.domain.model.Card;
import poker.domain.model.Player;
import poker.domain.model.PlayerName;
import poker.domain.model.CpuExchange;
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
		
		int numberOfComputer = inputNumberOfComputer(scan.nextLine());

			PokerService pokerService = new PokerService(numberOfComputer);
		
			//初期状態
			pokerService.initialize();
			List<Player> players = pokerService.getPlayers();
			println("初めのカードが配られました。\n");

			println("ラウンド1 \n");

			for (Player player : players) {
				pokerService.chooseTargetPlayer(player);
				println(player.getName());
				printHand(pokerService.getPlayerHand());
				println("");
			}


			//カード交換
			int count = 0;
			boolean completeHand = false;
			String input = null;

			println("<カード交換>");
			println("交換したいカードの番号を選んでください。");
			println("番号は左から0,1,2,3,4となっていて、複数交換する場合は　,　で区切ってください。");
			println("交換せず終了する場合は、'q' を入力してください。\n");
 
			loop : while (count < MAX_EXCHANGE_NUM) {
				println("ラウンド" + (count+2) + "\n");

				for (Player player : players) {
					println(player.getName() + "　のターンです。");

					pokerService.chooseTargetPlayer(player);

					//enumで名前を区別
					// Enum { People, CPU };
					// isCPU() // true = CPU, false=人間
					if ( player.getName().equals(PlayerName.PLAYER.getName()) ) {
						input = scan.nextLine().trim();
						
						//ゲーム終了
						if (inputValueIsQuit(input)) {
							printHand(pokerService.getPlayerHand());
							continue;
						}
	
						try {
							int[] indices = parseInputValue(input);
							pokerService.exchangeCard(indices);
	
						} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
							println("入力値が誤っています。");
							println("終了します。");
							e.printStackTrace();
							break;
						}
					} else {
						CpuExchange cpuExchange = new CpuExchange();
						int[] indices = cpuExchange.getIndices(player);
						if (indices != null) {
							pokerService.exchangeCard(indices);
						} else {
							completeHand = cpuExchange.completeHand(player, pokerService.getNumberOfComputer());
						}
					}

					printHand(pokerService.getPlayerHand());

					if (inputValueIsQuit(input) && completeHand) {
						break loop;
					}
				}

				println("");

				count++;

			}

			//結果
			println("<結果>");
			List<Player> rankList = pokerService.result();
			for (int i = 0; i < rankList.size() ; i++) {
				println((i+1) + "位 : " + rankList.get(i).getName());
			}

		scan.close();
	}
		


	//System.out.printlnの簡略版
	static void println(String message) {
		System.out.println(message);
	}

	//コンピュータ数の入力
	static int inputNumberOfComputer(String stringNum) {
		try {
			int num = Integer.parseInt(stringNum);
			if (!(0 <= num && num <= 2)) {
				throw new IllegalArgumentException("0～3 の数を入力してください。");
			}
			return num;

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		
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
