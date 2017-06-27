package cards;

public enum Color {

	CLUBS, // kreuz

	SPADES, // pik

	HEARTS, // herz

	DIAMONDS, // karo
	
	NONE; // nichts

	public String toString() {
		switch (this) {
		case CLUBS:
			return "clubs";
		case SPADES:
			return "spades";
		case HEARTS:
			return "hearts";
		case DIAMONDS:
			return "diamonds";
		case NONE:
			return "colorless";
		default:
			throw new IllegalArgumentException("no such Enum");
		}
	}

}
