package cards;

public enum Value {

	N_2,

	N_3,

	N_4,

	N_5,

	N_6,

	N_7,

	N_8,

	N_9,

	N_10,

	JACK,

	QUEEN,

	KING,

	ACE,
	
	JOKER;

	public String toString() {
		switch (this) {
		case N_2:
			return "2";
		case N_3:
			return "3";
		case N_4:
			return "4";
		case N_5:
			return "5";
		case N_6:
			return "6";
		case N_7:
			return "7";
		case N_8:
			return "8";
		case N_9:
			return "9";
		case N_10:
			return "10";
		case JACK:
			return "jack";
		case QUEEN:
			return "queen";
		case KING:
			return "king";
		case ACE:
			return "ace";
		case JOKER:
			return "joker";
		default:
			throw new IllegalArgumentException("no such Enum");
		}
	}

}
