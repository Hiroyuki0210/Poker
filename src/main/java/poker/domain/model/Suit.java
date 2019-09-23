package poker.domain.model;

public enum Suit {
	SPADE("♠", 3),
	HEART("♥", 2),
	DIAMOND("♦", 1),
	CLOVER("♣", 0),
	;

	// Field
	public final String icon;
	public final int strength;

	// Constructor
	Suit(String icon, int strength) {
		this.icon = icon;
		this.strength = strength;
	}
}
