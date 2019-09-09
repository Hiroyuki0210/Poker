package poker.app.cli;

import java.util.*;

import poker.domain.model.Card;
import poker.domain.service.PlayerHandDetail;
import poker.domain.service.PokerService;

/**
 * CLI 版
 */
public class PlayPoker {
	private static final int MAX_EXCHANGE_COUNT = 3;

	public static void main(String[] arg) {
		var pokerService = new PokerService();
		pokerService.initialize();

		// 初期状態
		printHand(pokerService.getPlayerHand());

		// 標準入力
		var scanner = new Scanner(System.in);

		int count = 0;
		while (count < MAX_EXCHANGE_COUNT) {
			println("交換したいカードの番号を選んでください(番号は左から0,1,2,3,4となっていて、複数ある場合は　,　で区切ってください");
			println("交換せず終了する場合は 'q' を入力してください");
			var in = scanner.nextLine();

			if (inputValueIsQuit(in)) {
				break;
			}

			try {
				var indexes = parseInputValue(in);
				pokerService.changeCard(indexes);
				printHand(pokerService.getPlayerHand());
				count++;
			} catch(IllegalArgumentException ignore) {}
		}
	}

	static boolean inputValueIsQuit(String line) {
		return "q".equals(line);
	}

	static int[] parseInputValue(String line) {
		try {
			return Arrays.stream(line.split(","))
					.filter(str -> !str.isEmpty())
					.mapToInt(Integer::parseInt)
					.toArray();
		} catch(NumberFormatException e) {
			// 数値以外を入力した
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	private static void println(String message) {
		System.out.println(message);
	}

	private static void printHand(PlayerHandDetail playerHandDetail) {
		println("手札 : " + cardsToText(playerHandDetail.getCards()));
		println("役   : " + playerHandDetail.getHand().getName());
	}

	private static String cardsToText(List<Card> cards) {
		var sb = new StringBuilder();

		for (Card card : cards) {
			sb.append(card.getSuit().icon);
			sb.append(card.getNum());
			sb.append(" ");
		}

		return sb.toString();
	}
}
