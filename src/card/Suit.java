package card;

public enum Suit {
	SPADE("♠", 0),
	HEART("♥", 1),
	DIAMOND("♦", 2),
	CLOVER("♣", 3),
	;

	// Field
	public final String icon;
	public final int strength;

	// Constructor
	Suit(String icon, int strength){
		this.icon = icon;
		this.strength = strength;
	}
}
