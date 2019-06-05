package classproject;

import java.util.ArrayList;

abstract class Human {

	protected ArrayList<Integer> myCards = new ArrayList<Integer>();

	abstract public int open();
	abstract public void setCard(ArrayList<Integer> set);
	abstract public boolean checkSum();

}
/*Humanクラスに出てくる詳しいメソッドの説明はDealerクラスに記載*/
class User extends Human {
		public int open(){
			int usertotal = 0;
			for(int value: myCards) {
				if(value >= 11) {
					value =10;
					usertotal += value;
				}else {
				usertotal += value;
			}
			}
			return usertotal;
		}

		public void setCard(ArrayList<Integer> userCards) {
			for(int i=0; i < userCards.size(); i++) {
				myCards.add(userCards.get(i));
			}
		}

		public boolean checkSum(){
/*訂正*/	if(open()<=16) //←前回は open()>=1 && open()<=16 としていましたが、open()>=1 &&を省略しました！
			{
				return true;
			}
			else {
				return false;
			}
		}

}
