import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Judge.Judgement;
import card.Card;
import card.Deck;

public class PlayPoker {
	//ポーカーの実行
	public static void main(String arg[]) {
		try {
			System.out.println("Let's do Poker!! Write start");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			if(line.equals("start")) {
				Deck deck = new Deck();                  //山札
		    	List<Card> hand = new ArrayList<Card>(); //プレイヤー側の手札
		    	Card ca = new Card(null, 0);             //手札のソート用

		    	deck.shuffle();

		    	System.out.print("手札 : 　");
		    	for(int i=0; i < 5; i++){
		    		hand.add(deck.draw());
		    	}
		    	ca.sort(hand);

		    	for(int i=0; i<hand.size(); i++) {
		    		System.out.print(hand.get(i).getSuit().icon+hand.get(i).getNum()+"　");
		    	}
		    	System.out.println("");
		    	System.out.print(Judgement.getInstance().result(hand)+"\n"+"\n");

		    	boolean flag = true;
		    	//交換操作を3回行う
		    	for(int i=0; i<3; i++){
		    		System.out.println("交換したいカードの番号を選んでください(番号は左から0,1,2,3,4となっていて、複数ある場合は　,　で区切ってください");
					System.out.println("交換したくない場合は,5を入力してください");
					String line2 = reader.readLine();
					String[] num = line2.split(",");

					if(Integer.parseInt(num[0]) != 5) {
						change(hand,deck,num);
					}else{
						for(int j=0; j<hand.size(); j++) {
				    		System.out.print(hand.get(j).getSuit().icon+hand.get(j).getNum()+"　");
				    	}
						System.out.print("\n"+Judgement.getInstance().result(hand)
								);
						break ;
					}
		    	}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException | IndexOutOfBoundsException e2){
			System.out.println("※0～5の数字を入力してください。ゲームを終了します。\n");
		}
	}


	//カード交換用のメソッド
	/**
	 * @param hand
	 * @param deck
	 */
	public static void change(List<Card> hand, Deck deck, String[] num)  throws IndexOutOfBoundsException{

			Card ca = new Card(null,0);             //手札のソート用
			List<Card> set = new ArrayList<>();     //削除するカードを一時的にsetに格納

			if(Integer.parseInt(num[0]) != 5) {
	    	for(int i=0; i < num.length; i++){
	    		Collections.addAll(set, hand.get(Integer.parseInt(num[i])) );
	    		hand.add(deck.draw());
	    	}
	    	hand.removeAll(set);
	    	ca.sort(hand);
			}

	    	System.out.print("手札 : 　");
	    	for(int i=0; i<hand.size(); i++) {
	    		System.out.print(hand.get(i).getSuit().icon+hand.get(i).getNum()+"　");
	    	}
	    	System.out.print("\n"+Judgement.getInstance().result(hand)+"\n"+"\n");
	}
}
