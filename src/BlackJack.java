package classproject;

public class BlackJack {

	public static void main(String[] args) {
		User user = new User();               //Userクラスのインスタンス作成
		Dealer dealer = new Dealer();         //Dealerクラスのインスタンス作成//デッキのセット



		user.setCard(dealer.deal());                                                   //userがdealerからカードを2枚もらう

		System.out.println("userに配られたカードは"+user.myCards+"です。");           //userに配られたカードの表示。
		System.out.println("カードの合計は"+user.open()+"です。");

		dealer.setCard(dealer.deal());												   //dealerが自身にカードを2枚配る
		System.out.println("dealerに配られたカードは"+dealer.myCards+"です。");
		System.out.println("カードの合計は"+dealer.open()+"です。");

		/*BlackJackが発生した場合*/
		if(user.open()==21 && dealer.open()!=21) {
			System.out.println("userは、BlackJack により勝利です!");
		}else if(user.open()!=21 && dealer.open()==21) {
			System.out.println("dealerがBlackJack により、userは負けです。。。");
		}else {

			/*BlackJackが発生しない場合*/

			/*userの手札合計が17以上になるまでhitし続ける*/
			while(user.checkSum()) {
					user.setCard(dealer.hit());
					System.out.println("userのカードの合計が16以下だったので、もう一枚引きました。その結果、合計は"+user.open()+"となりました。");
			}

			if(user.open()>21) {
				System.out.println("合計が21を超えてしまったので、userの負けです。。。");
			}
			else {
				System.out.println("userは"+user.open()+"で勝負します!");

				/*dealerの手札合計が17以上になるまでhitし続ける*/
				while(dealer.checkSum()) {
					dealer.setCard(dealer.hit());
					System.out.println("dealerのカードの合計が16以下だったので、もう一枚引きました。その結果、合計は"+dealer.open()+"となりました。");
				}

				if(dealer.open()>21) {
					System.out.println("合計が21を超えたので、userの勝利です！");
				}
				else {
					System.out.println("dealerは"+dealer.open()+"で勝負してきます！");

					/*最終的なuserとdealerの手札合計値の比較*/
					if(dealer.open() < user.open()) {
						System.out.print("userの勝利です!");
					}else if(dealer.open() > user.open()) {
						System.out.print("userの負けです。。。");
					}else {
						System.out.print("ドローです。");
					}
				}
			}
		}
	}

}


