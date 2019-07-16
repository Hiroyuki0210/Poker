package poker;

//役の名前&強さの列挙型
public enum PokerHand {
	ROYALSTRAIGHTFLASH("ロイヤルストレートフラッシュ",9),
	STRAIGHTFLASH("ストレートフラッシュ",8),
	FOURCARD("4カード",7),
	FULLHOUSE("フルハウス",6),
	FLASH("フラッシュ",5),
	STRAIGHT("ストレート",4),
	THREECARD("3カード",3),
	TWOPAIR("2ペア",2),
	ONEPAIR("1ペア",1),
	NOTHING("",0)
	;

	//Field
	public final String yaku;
	public final int strength;

	//Constructor
	PokerHand(String yaku,int strength){
		this.yaku = yaku;
		this.strength = strength;
	}

	public String getName() {
		return this.yaku;
	}
	public int getStrength() {
		return this.strength;
	}
}