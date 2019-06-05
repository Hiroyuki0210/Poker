package play;

//配るカードの番号とマークに関するクラス
public class CardDetail {
	int num = 0;
	String type = "";

	//カードの番号に関するgetter&setter
	public int getNum() {
		return num ;
	}
	//注意　フィールドにセットする値は実際のカードの番号
	public void setNum(int num) {
		if(0 <= num && num <13) {
			this.num = num + 1;
		}
		if(13 <= num && num <26) {
			this.num = num -12;
		}
		if(26 <= num && num <39) {
			this.num = num -25;
		}
		if(39 <= num && num <52) {
			this.num = num - 38;
		}
	}

	//カードのマークに関するgetter&setter
	public String getType() {
		return type ;
	}
	public void setType(int num) {
		if(0 <= num && num <13) {
			this.type = "スペード♠";
		}
		if(13 <= num && num <26) {
			this.type = "クローバー🍀";
		}
		if(26 <= num && num <39) {
			this.type = "ハート♥";
		}
		if(39 <= num && num <52) {
			this.type = "ダイヤ♦";
		}
	}
}
